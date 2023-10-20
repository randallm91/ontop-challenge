package ontop.service_helper;

import ontop.business.CalculateAmounts;
import ontop.business.Currency;
import ontop.entity.OntopAccounts;
import ontop.entity.Recipients;
import ontop.service.RecipientsServiceImpl;
import ontop.service_gateways.WalletTransactionsApiServiceImpl;
import ontop.transferModels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class TransactionServiceJHelper {

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
    @Autowired
    OntopAccounts ontopAccounts;
    @Autowired
    Recipients recipients;
    @Autowired
    TransactionRequest transactionRequest;
    @Autowired
    WalletRequest walletRequest;
    @Autowired
    RecipientsServiceImpl recipientsService;

    public TransferRequest createTransferStructure(String accountNumber, BigDecimal amount){

        Optional<Recipients> optionalRecipients= recipientsService.getRecipientBankInformationByAccountNumber(accountNumber);
        recipients = optionalRecipients.orElse(new Recipients());

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
        destinationAccount.setCurrency(Currency.USD.toString());
        destinationAccount.setRoutingNumber(recipients.getRoutingNumber());

        transferRequest.setSource(source);
        transferRequest.setDestination(destination);
        transferRequest.setAmount(amount);

        return transferRequest;
    }

    public WalletRequest setAmountToUpdateBalance(int userId, BigDecimal amount){
        walletRequest.setUserId(userId);
        walletRequest.setAmount(amount);
        return walletRequest;
    }
}
