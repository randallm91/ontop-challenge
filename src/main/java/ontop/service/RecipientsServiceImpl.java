package ontop.service;

import ontop.entity.Recipients;
import ontop.exceptions.RecipientNotFoundException;
import ontop.repository.RecipientsRepository;
import ontop.validations.RecipientsValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipientsServiceImpl implements RecipientsService {

    @Autowired
    RecipientsRepository informationRepository;

    @Autowired
    RecipientsValidations validations;

    @Override
    public Recipients addRecipientBankInformation(Recipients recipients){
        if(validations.validateUserBankInformation(recipients)){
             informationRepository.save(recipients);
        }
        return recipients;
    }

    @Override
    public List<Recipients> getRecipientsBankInformation() {
        return informationRepository.findAll();
    }

    @Override
    public Optional<Recipients> getRecipientBankInformationByAccountNumber(String accountNumber) {
        Optional<Recipients> recipientsBankInformation = informationRepository.findRecipientByAccountNumber(accountNumber);
        if(recipientsBankInformation.isEmpty()){
            throw new RecipientNotFoundException("Recipient Not Found");
        }
        return recipientsBankInformation;
    }
}
