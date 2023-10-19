package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TransferRequest {
    @JsonProperty("source")
    private Source source;
    @JsonProperty("destination")
    private Destination destination;
    @JsonProperty("amount")
    private BigDecimal amount;
}
