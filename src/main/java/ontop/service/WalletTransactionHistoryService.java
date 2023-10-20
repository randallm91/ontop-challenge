package ontop.service;

import ontop.entity.WalletTransactionHistory;

import java.math.BigDecimal;
import java.util.Optional;

public interface WalletTransactionHistoryService {

    void saveWalletTransactionInformation(int userId, BigDecimal amount);

    Optional<WalletTransactionHistory> getWalletTransactionHistoryById(int userId);
}
