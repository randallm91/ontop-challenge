package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TransferResponse {
    @JsonProperty("requestInfo")
    private RequestInfo requestInfo;
    @JsonProperty("paymentInfo")
    private PaymentInfo paymentInfo;
}
