package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponse {
    @JsonProperty("wallet_transaction_id")
    private int walletTransactionId;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("user_id")
    private int userId;
}
