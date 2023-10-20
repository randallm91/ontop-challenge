package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentInfo {
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("id")
    private String id;
}
