package ontop.service;

import ontop.transferModels.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransactionsService {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);
    LocalDate getActualDate();

    BigDecimal updatedBalance(WalletRequest walletRequest , int userId);

    BigDecimal getCurrentBalance(int userId);

    BigDecimal getAmount(WalletRequest walletRequest);

    double getFee();

    boolean availableWalletFunds(BigDecimal amount, BigDecimal currentBalance);

    TransferResponse transferFunds(TransferRequest transferRequest);
}
