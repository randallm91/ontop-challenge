package ontop.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "transactions")
public class Transactions {

    @Id
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "recipient_id")
    private int recipientId;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "net_amount")
    private BigDecimal netAmount;
    @Column(name = "fees")
    private double fees;
    @Column(name = "transaction_date")
    private LocalDate transactionDate;
    @Column(name = "transaction_status")
    private int status;



}
