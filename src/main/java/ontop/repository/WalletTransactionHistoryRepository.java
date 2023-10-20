package ontop.repository;

import ontop.entity.WalletTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionHistoryRepository extends JpaRepository<WalletTransactionHistory, Integer> {
}
