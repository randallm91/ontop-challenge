package ontop.repository;

import ontop.entity.WalletTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionHistoryRespository extends JpaRepository<WalletTransactionHistory, Integer> {
}
