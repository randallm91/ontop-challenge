package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Balance {
    @JsonProperty("balance")
    private BigDecimal balance;
    @JsonProperty("user_id")
    private int userId;


}
