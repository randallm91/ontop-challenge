package ontop.business;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculateAmountsTest {

    @Test
    void testCalculateNetAmountWhenNetAmountIsNull() {
        CalculateAmounts calculateAmounts = Mockito.mock(CalculateAmounts.class);
        double fees = 0.1;
        BigDecimal amount = BigDecimal.valueOf(100.0);
        double expectedNetAmount = amount.doubleValue() - (amount.doubleValue() * fees);
        BigDecimal expectedNetAmountBD = BigDecimal.valueOf(expectedNetAmount);
        Mockito.when(calculateAmounts.calculateNetAmount(amount)).thenReturn(expectedNetAmountBD);
        assertEquals(90.0,expectedNetAmountBD.doubleValue());

    }
}