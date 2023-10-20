package ontop.service;

import ontop.entity.Recipients;

import java.util.List;
import java.util.Optional;

public interface RecipientsService {

    Recipients addRecipientBankInformation(Recipients information);

    List<Recipients> getRecipientsBankInformation();

    Optional<Recipients> getRecipientBankInformationByAccountNumber(String accountNumber);
}
