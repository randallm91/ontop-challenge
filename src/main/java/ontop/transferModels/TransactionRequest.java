package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    @JsonProperty("userId")
    private int userId;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("accountNumber")
    private String accountNumber;
}
