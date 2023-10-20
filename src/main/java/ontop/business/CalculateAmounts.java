package ontop.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
public class CalculateAmounts {

    final Double fees = 0.1;
    public BigDecimal calculateNetAmount(BigDecimal amount){
        double netAmount = amount.doubleValue() - (amount.doubleValue() * fees);
        return BigDecimal.valueOf(netAmount);
    }
}
