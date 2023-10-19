package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletRequest {
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("user_id")
    private int userId;
}
