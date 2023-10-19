package ontop.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CalculateAmounts {

    final double fees = 0.10;
    public BigDecimal calculateNetAmount(BigDecimal amount){
        double netAmount = amount.doubleValue() - (amount.doubleValue() * fees);
        return BigDecimal.valueOf(netAmount);
    }
}
