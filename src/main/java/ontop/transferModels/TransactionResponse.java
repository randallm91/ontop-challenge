package ontop.transferModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("fee")
    private double fee;
    @JsonProperty("net_amount")
    private BigDecimal netAmount;
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("status")
    private String status;


}
