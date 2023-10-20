package ontop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet_transaction_history")
public class WalletTransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_transaction_id")
    private int walletTransactionId;
    @Column(name = "user_id")
    private int userID;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "transaction_status")
    private String transactionStatus;
    @Column(name = "history_date")
    private LocalDate historyDate;

}
