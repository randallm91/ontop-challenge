package ontop.validations;

import ontop.entity.Recipients;
import ontop.exceptions.AccountNumberException;
import ontop.exceptions.AmountException;
import ontop.exceptions.NullRecipientFieldException;
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
    public boolean validateAmountToSendIsNotNull(BigDecimal amount){
        if(amount != null){
            return true;
        }
        throw new AmountException("The amount to send must not be null");
    }
    public boolean validateUserIdIsNotNull(Integer userId){
        if(userId != null){
            return true;
        }
        throw new NullRecipientFieldException("user_id must not be null");
    }
    public boolean validateAccountNumberExist(String accountNumber){
        Optional<Recipients> opt = recipientsRepository.findRecipientByAccountNumber(accountNumber);
        if(opt.isPresent()) {
            return true;
        }
        throw new AccountNumberException("Account number not founds");
    }
    public boolean validateTransactionInformation(TransactionRequest transactionRequest){
        if(transactionRequest == null){
            return false;
        }
        else if(validateAmountToSendIsNotNull(transactionRequest.getAmount()) ||
                validateUserIdIsNotNull(transactionRequest.getUserId())||
                validateAccountNumberExist(transactionRequest.getAccountNumber())){
            return true;
        }
        return false;
    }

}
