package ontop.service;

import ontop.business.TransactionStatus;
import ontop.entity.WalletTransactionHistory;
import ontop.repository.WalletTransactionHistoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class WalletTransactionHistoryServiceImpl implements WalletTransactionHistoryService{
    @Autowired
    WalletTransactionHistory walletTransactionHistory;
    @Autowired
    WalletTransactionHistoryRespository historyRepository;
    @Override
    public void saveWalletTransactionInformation(int userId, BigDecimal amount) {
        walletTransactionHistory.setUserID(userId);
        walletTransactionHistory.setAmount(amount);
        walletTransactionHistory.setTransactionStatus(TransactionStatus.INITIATED.toString());
        walletTransactionHistory.setHistoryDate(LocalDate.now());
        historyRepository.save(walletTransactionHistory);
    }

    @Override
    public Optional<WalletTransactionHistory> getWalletTransactionHistoryById(int userId) {
        return historyRepository.findById(userId);
    }


}
