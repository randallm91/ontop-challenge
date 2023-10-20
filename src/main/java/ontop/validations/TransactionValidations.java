package ontop.validations;

import ontop.entity.Recipients;
import ontop.exceptions.*;
import ontop.repository.RecipientsRepository;

import ontop.transferModels.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class TransactionValidations {

    @Autowired
    RecipientsRepository recipientsRepository;
    public boolean validateAmountToSendIsNotNull(BigDecimal amount) throws AmountException{
        if(amount != null){
            return true;
        }
        throw new AmountException("The amount to send must not be null");
    }

    public boolean validateAmountToSendIsNot0(BigDecimal amount) throws AmountException{
        if(amount.compareTo(BigDecimal.ZERO) > 0){
            return true;
        }else if(amount.compareTo(BigDecimal.ZERO)<0){
            throw new AmountException("The amount to transfer must be bigger than 0");
        }
       return false;
    }

    public boolean validateUserIdIsNotNull(Integer userId) throws NullRecipientFieldException{
        if(userId != null){
            return true;
        }
        throw new NullRecipientFieldException("user_id must not be null");
    }
    public boolean validateIfAccountNumberExist(String accountNumber) throws AccountNumberException{
        Optional<Recipients> opt = recipientsRepository.findRecipientByAccountNumber(accountNumber);
        if(opt.isPresent()) {
            return true;
        }
        throw new AccountNumberException("Account number not founds");
    }

    public boolean validateIfUserIfExist(int userId) throws InvalidTransactionException {
        Optional<Recipients> opt = recipientsRepository.findRecipientByUserId(userId);
        if(opt.isPresent()) {
            return true;
        }
        throw new InvalidTransactionException("user_id not found");
    }

    public boolean validateTransactionInformation(TransactionRequest transactionRequest){
        if(transactionRequest == null){
            return false;
        }
        else return validateAmountToSendIsNotNull(transactionRequest.getAmount()) &&
                validateUserIdIsNotNull(transactionRequest.getUserId()) &&
                validateIfAccountNumberExist(transactionRequest.getAccountNumber())&&
                validateAmountToSendIsNot0(transactionRequest.getAmount())&&
                validateIfUserIfExist(transactionRequest.getUserId());
    }

}
