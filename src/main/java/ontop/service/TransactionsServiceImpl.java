package ontop.service;

import ontop.business.CalculateAmounts;
import ontop.entity.Recipients;
import ontop.entity.Transactions;
import ontop.exceptions.BalanceException;
import ontop.repository.TransactionsRepository;
import ontop.service_gateways.BalanceTransactionsApiServiceImpl;
import ontop.service_gateways.PaymentsApiServiceImpl;
import ontop.service_gateways.WalletTransactionsApiServiceImpl;
import ontop.service_helper.TransactionServiceJHelper;
import ontop.transferModels.*;
import ontop.validations.TransactionValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService{

    @Autowired
    WalletTransactionsApiServiceImpl transactionsApiService;
    @Autowired
    CalculateAmounts amounts;
    @Autowired
    BalanceTransactionsApiServiceImpl balanceTransactionsApiService;
    @Autowired
    Recipients recipients;
    @Autowired
    RecipientsServiceImpl recipientsService;
    @Autowired
    TransactionValidations transactionValidations;
    @Autowired
    TransactionResponse transactionResponse;
    @Autowired
    PaymentsApiServiceImpl paymentsApiService;
    @Autowired
    TransactionsRepository transactionsRepository;
    @Autowired
    TransactionServiceJHelper transactionServiceJHelper;
    @Autowired
    WalletResponse walletResponse;
    @Autowired
    TransferResponse transferResponse;
    @Autowired
    Transactions transactions;
    @Autowired
    WalletTransactionHistoryServiceImpl walletTransactionServiceHistory;

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest){

        BigDecimal currentBalance = getCurrentBalance(transactionRequest.getUserId());

        if(transactionValidations.validateTransactionInformation(transactionRequest)){
            if(availableWalletFunds(transactionRequest.getAmount(),currentBalance)){

                transferResponse = transferFunds(transactionServiceJHelper.createTransferStructure(transactionRequest.getAccountNumber(),transactionRequest.getAmount()));
                walletResponse = updateBalance(transactionServiceJHelper.setAmountToUpdateBalance(transactionRequest.getUserId(), transactionRequest.getAmount()));

                transactionResponse.setMessage("Transaction succeed!");
                transactionResponse.setAmount(transactionRequest.getAmount());
                transactionResponse.setFee(amounts.getFees());
                transactionResponse.setNetAmount(amounts.calculateNetAmount(transactionRequest.getAmount()));
                transactionResponse.setDate(getActualDate());
                transactionResponse.setStatus(transferResponse.getRequestInfo().getStatus());

                saveTransactionInformation(transactionRequest.getUserId(), transactionRequest.getAccountNumber());
                walletTransactionServiceHistory.saveWalletTransactionInformation(transactionRequest.getUserId(), walletResponse.getAmount());

            }
        }
        return transactionResponse;
    }

    public void saveTransactionInformation(int userId, String accountNumber){
        Optional<Recipients> optionalRecipients= recipientsService.getRecipientBankInformationByAccountNumber(accountNumber);
        recipients = optionalRecipients.orElse(new Recipients());

        transactions.setUserId(userId);
        transactions.setRecipientId(recipients.getRecipientId());
        transactions.setAmount(walletResponse.getAmount());
        transactions.setNetAmount(transactionResponse.getNetAmount());
        transactions.setFees(amounts.getFees());
        transactions.setTransactionDate(getActualDate());
        transactions.setStatus(transactionResponse.getStatus());
        transactionsRepository.save(transactions);
    }
    @Override
    public LocalDate getActualDate(){
        return LocalDate.now();
    }

    @Override
    public WalletResponse updateBalance(WalletRequest walletRequest) {
        return transactionsApiService.getTransactionFromExternalApi(walletRequest);
    }

    @Override
    public double getFee() {
        return amounts.getFees();
    }

    @Override
    public TransferResponse transferFunds(TransferRequest transferRequest) {
        return paymentsApiService.executeTransference(transferRequest);
    }
    @Override
    public BigDecimal getCurrentBalance(int userId) {
        return balanceTransactionsApiService.getBalanceTransactionFromExternalApi(userId).getBalance();
    }
    @Override
    public boolean availableWalletFunds(BigDecimal amount, BigDecimal currentBalance){
        int comparisonResult = currentBalance.compareTo(amount);
        if(comparisonResult < 0 ){
            throw new BalanceException("Insufficient funds to complete the transaction");
        }
        return true;
    }
}
