package ontop.validations;

import ontop.exceptions.NullRecipientFieldException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;


class RecipientsValidationsTest {
    @Test
    void testWhenIsFirstNameNullIsNotNull() {
        RecipientsValidations recipientsValidations = new RecipientsValidations();
        recipientsValidations.isFirstNameNull("Randall");
        assertTrue(true);

    }
    @Test
    void testWhenIsFirstNameNullIsNull() {
        RecipientsValidations recipientsValidations = new RecipientsValidations();
        Executable executable = () -> recipientsValidations.isFirstNameNull(null);
        assertThrows(NullRecipientFieldException.class,executable);
    }

    @Test
    void testWhenIsLastNameNullIsNotNull() {
        RecipientsValidations recipientsValidations = new RecipientsValidations();
        recipientsValidations.isLastNameNull("Mora");
        assertTrue(true);
    }
    @Test
    void testWhenIsLastNameNullIsNull() {
        RecipientsValidations recipientsValidations = new RecipientsValidations();
        Executable executable = () -> recipientsValidations.isLastNameNull(null);
        assertThrows(NullRecipientFieldException.class,executable);
    }

    @Test
    void testWhenIsRoutingNumberNullIsNotNull() {
        RecipientsValidations recipientsValidations = new RecipientsValidations();
        recipientsValidations.isRoutingNumberNull("123456");
        assertTrue(true);
    }

    @Test
    void testWhenIsRoutingNumberNullIsNull() {
        RecipientsValidations recipientsValidations = new RecipientsValidations();
        Executable executable = () -> recipientsValidations.isRoutingNumberNull(null);
        assertThrows(NullRecipientFieldException.class,executable);
    }

    @Test
    void isNationalIdentificationNumberNull() {
    }

    @Test
    void validateIfNationalIdentificationNumberAlreadyExist() {
    }

    @Test
    void validateIfAccountNumberAlreadyExist() {
    }

    @Test
    void isAccountNumberNull() {
    }

    @Test
    void validateIfRecipientAlreadyExist() {
    }

    @Test
    void validateUserBankInformation() {
    }
}