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

    public boolean validateIfFirstNameIsNotNull(String firstName) throws NullRecipientFieldException{
            if(firstName != null && !firstName.isEmpty()) {
                return true;
            }
        throw new NullRecipientFieldException("First Name can not be null or empty");
    }
    public boolean validateIfLastNameIsNotNull(String lastName) throws NullRecipientFieldException{
        if(lastName != null && !lastName.isEmpty()){
            return true;
        }
        throw new NullRecipientFieldException("Last Name can not be null or empty");
    }
    public boolean validateIfRoutingNumberIsNotNull(String routingNumber) throws NullRecipientFieldException{
        if(routingNumber != null && !routingNumber.isEmpty()){
            return true;
        }
        throw new NullRecipientFieldException("Routing Number can not be null or empty");
    }
    public boolean validateIfNationalIdentificationNumberIsNotNull(String identificationNumber) throws NullRecipientFieldException{
        if(identificationNumber != null && !identificationNumber.isEmpty()){
            return true;
        }
        throw new NullRecipientFieldException("National Identification Number can not be null or empty");
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

    public boolean validateIfAccountNumberIsNotNull(String accountNumber) throws AccountNumberException{
        if(accountNumber != null && !accountNumber.isEmpty()){
            return true;
        }
        throw new AccountNumberException("Account Number can not be null or empty");
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
        else return (validateIfFirstNameIsNotNull(information.getFirstName())&&
                validateIfLastNameIsNotNull(information.getLastName())&&
                validateIfRoutingNumberIsNotNull(information.getRoutingNumber())&&
                validateIfNationalIdentificationNumberIsNotNull(information.getNationalIdentificationNumber())&&
                validateIfNationalIdentificationNumberAlreadyExist(information.getNationalIdentificationNumber())&&
                validateIfAccountNumberAlreadyExist(information.getAccountNumber())&&
                validateIfAccountNumberIsNotNull(information.getAccountNumber())&&
                validateIfRecipientAlreadyExist(information.getUserId(),information.getAccountNumber()));
    }
}
