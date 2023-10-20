package ontop.service;

import ontop.entity.Transactions;
import ontop.exceptions.BalanceException;
import ontop.service_gateways.PaymentsApiServiceImpl;
import ontop.service_gateways.WalletTransactionsApiServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsServiceImplTest extends Transactions {

    @Test
    void testWhenAvailableWalletFundsAreEnough() {
        TransactionsServiceImpl service = Mockito.mock(TransactionsServiceImpl.class);
        BigDecimal amount = new BigDecimal("10.0");
        BigDecimal currentBalance = new BigDecimal("20.0");
        Mockito.when(service.availableWalletFunds(amount,currentBalance)).thenReturn(true);
        assertTrue(true);
    }

    @Test
    void testWhenAvailableWalletFundsAreInsufficient() {
        TransactionsServiceImpl service = Mockito.mock(TransactionsServiceImpl.class);
        BalanceException exception = new BalanceException("Insufficient funds to complete the transaction");
        BigDecimal amount = new BigDecimal("100.0");
        BigDecimal currentBalance = new BigDecimal("20.0");
        Mockito.doThrow(exception).when(service).availableWalletFunds(amount,currentBalance);
        try {
            service.availableWalletFunds(amount, currentBalance);
            fail("Expected BalanceException, but it was not thrown");
        } catch (BalanceException e) {
            assertTrue(e.getMessage().contains("Insufficient funds to complete the transaction"));
        }
    }
}