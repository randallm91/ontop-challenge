package ontop.service;

import ontop.business.CalculateAmounts;
import ontop.entity.OntopAccounts;
import ontop.entity.Recipients;
import ontop.exceptions.BalanceException;
import ontop.repository.RecipientsRepository;
import ontop.repository.TransactionsRepository;
import ontop.service_gateways.BalanceTransactionsApiServiceImpl;
import ontop.service_gateways.PaymentsApiServiceImpl;
import ontop.service_gateways.WalletTransactionsApiServiceImpl;
import ontop.transferModels.*;
import ontop.validations.TransactionValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
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
    OntopAccounts ontopAccounts;
    @Autowired
    TransactionValidations transactionValidations;
    @Autowired
    TransactionResponse transactionResponse;
    @Autowired
    PaymentsApiServiceImpl paymentsApiService;
    @Autowired
    TransactionsRepository transactionsRepository;
    @Autowired
    Source source;
    @Autowired
    SourceInformation sourceInformation;
    @Autowired
    SourceAccount sourceAccount;
    @Autowired
    Destination destination;
    @Autowired
    DestinationAccount destinationAccount;
    @Autowired
    TransferRequest transferRequest;

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest){

        BigDecimal currentBalance = getCurrentBalance(transactionRequest.getUserId());

        Optional<Recipients> optionalRecipients= recipientsService.getRecipientBankInformationByAccountNumber(transactionRequest.getAccountNumber());
        recipients = optionalRecipients.orElse(new Recipients());

        if(availableWalletFunds(transactionRequest.getAmount(),currentBalance)){
            if(transactionValidations.validateTransactionInformation(transactionRequest)){

                source.setType(ontopAccounts.getAccountType());
                source.setSourceInformation(sourceInformation);
                source.setAccount(sourceAccount);

                sourceInformation.setName(ontopAccounts.getAccountName());

                sourceAccount.setAccountNumber(ontopAccounts.getAccountNumber());
                sourceAccount.setCurrency(ontopAccounts.getCurrency());
                sourceAccount.setRoutingNumber(ontopAccounts.getRoutingNumber());

                destination.setName(recipients.getFirstName());
                destination.setAccount(destinationAccount);

                destinationAccount.setAccountNumber(recipients.getAccountNumber());
                destinationAccount.setCurrency(Currency.getInstance("USD").toString()); //revisar esto
                destinationAccount.setRoutingNumber(recipients.getRoutingNumber());

                transferRequest.setSource(source);
                transferRequest.setDestination(destination);
                transferRequest.setAmount(transactionRequest.getAmount());

                TransferResponse transferResponse = transferFunds(transferRequest);

                transactionResponse.setAmount(transactionRequest.getAmount());
                transactionResponse.setFee(amounts.getFees());
                transactionResponse.setNetAmount(amounts.calculateNetAmount(transactionRequest.getAmount()));
                transactionResponse.setDate(getActualDate());
                transactionResponse.setMessage("Transaction succeed!");
                transactionResponse.setStatus(transferResponse.getRequestInfo().getStatus());

            }
        }

        return transactionResponse;
    }

    @Override
    public LocalDate getActualDate(){
        return LocalDate.now();
    }

    @Override
    public BigDecimal getAmount(WalletRequest walletRequest) {
        return transactionsApiService.getTransactionFromExternalApi(walletRequest).getAmount();
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
    public BigDecimal updatedBalance(WalletRequest walletRequest, int userId) {
        BigDecimal currentBalance = getCurrentBalance(userId);
        BigDecimal amount = getAmount(walletRequest);
        return currentBalance.subtract(amount);
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
