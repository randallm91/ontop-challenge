package ontop.validations;

import ontop.entity.Recipients;
import ontop.exceptions.*;
import ontop.repository.RecipientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RecipientsValidations {

    @Autowired
    RecipientsRepository recipientsRepository;

    public boolean isFirstNameNull(String firstName) throws NullRecipientFieldException{
            if(firstName == null) {
                throw new NullRecipientFieldException("First Name can not be null");
            }
            return true;
    }
    public boolean isLastNameNull(String lastName) throws NullRecipientFieldException{
        if(lastName== null){
            throw new NullRecipientFieldException("Last Name can not be null");
        }
            return true;
    }
    public boolean isRoutingNumberNull(String routingNumber) throws NullRecipientFieldException{
        if(routingNumber== null){
           throw new NullRecipientFieldException("Routing Number can not be null");
        }
        else{
            return true;
        }
    }
    public boolean isNationalIdentificationNumberNull(String identificationNumber) throws NullRecipientFieldException{
        if(identificationNumber == null){
            throw new NullRecipientFieldException("National Identification Number can not be null");
        }
        else{
            return true;
        }
    }

   public boolean validateIfNationalIdentificationNumberAlreadyExist(String nationalIdentificationNumber) throws ExistentRecipientFieldException{
        Optional<Recipients> recipient = recipientsRepository.findRecipientByNationalIdentificationNumber(nationalIdentificationNumber);

        if(recipient.isPresent()){
            throw new ExistentRecipientFieldException("The National Identification Number Already Exist");
        }
        return true;
    }

    public boolean validateIfAccountNumberAlreadyExist(String accountNumber) throws AccountNumberException{
        Optional<Recipients> recipient = recipientsRepository.findRecipientByAccountNumber(accountNumber);

        if(recipient.isPresent()){
            throw new AccountNumberException("The Account Number Already Exist");
        }
        return true;
    }

    public boolean isAccountNumberNull(String accountNumber) throws AccountNumberException{
        if(accountNumber == null){
            throw new AccountNumberException("Account Number can not be null");
        }
        else{
            return true;
        }
    }

    public boolean validateIfRecipientAlreadyExist(int userId , String accountNumber) throws RecipientAlreadyExistException{
        Optional<Recipients> recipientByUserId = recipientsRepository.findRecipientByUserId(userId);
        Optional<Recipients> recipientByAccountNumber = recipientsRepository.findRecipientByAccountNumber(accountNumber);

        if(recipientByUserId.isPresent() && recipientByAccountNumber.isPresent()){
            throw new RecipientAlreadyExistException("The recipient already Exist");
        }
        return true;
    }

    public boolean validateUserBankInformation(Recipients information){
        if(information == null){
            return false;
        }
        else if(!isFirstNameNull(information.getFirstName()) ||
                !isLastNameNull(information.getLastName()) ||
                !isRoutingNumberNull(information.getRoutingNumber())||
                !isNationalIdentificationNumberNull(information.getNationalIdentificationNumber()) ||
                !isAccountNumberNull(information.getAccountNumber()) ||
                !validateIfNationalIdentificationNumberAlreadyExist(information.getNationalIdentificationNumber())||
                !validateIfAccountNumberAlreadyExist(information.getAccountNumber())||
                !validateIfRecipientAlreadyExist(information.getUserId(),information.getAccountNumber())){
            return false;
        }
        return true;
    }
}
