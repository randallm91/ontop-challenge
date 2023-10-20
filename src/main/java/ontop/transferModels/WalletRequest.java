package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WalletRequest {
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("user_id")
    private int userId;
}
