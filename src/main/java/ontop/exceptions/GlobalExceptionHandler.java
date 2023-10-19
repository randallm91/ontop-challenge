package ontop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullRecipientFieldException.class)
    ResponseEntity<ErrorDetails> nullRecipientFieldHandler(NullRecipientFieldException nullRecipientFieldException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(nullRecipientFieldException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ExistentRecipientFieldException.class)
    ResponseEntity<ErrorDetails> existentRecipientFieldHandler(ExistentRecipientFieldException existentRecipientFieldException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(existentRecipientFieldException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BalanceException.class)
    ResponseEntity<ErrorDetails> negativeBalanceHandler(BalanceException negativeBalanceException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(negativeBalanceException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountNumberException.class)
    ResponseEntity<ErrorDetails> accountNumberHandler(AccountNumberException accountNumberException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(accountNumberException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecipientAlreadyExistException.class)
    ResponseEntity<ErrorDetails> recipientAlreadyExistHandler(RecipientAlreadyExistException recipientAlreadyExistException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(recipientAlreadyExistException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecipientNotFoundException.class)
    ResponseEntity<ErrorDetails> amountExceptionHandler(RecipientNotFoundException recipientNotFoundException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(recipientNotFoundException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AmountException.class)
    ResponseEntity<ErrorDetails> amountExceptionHandler(AmountException amountException , WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails();

        errorDetails.setDateTime(LocalDateTime.now());
        errorDetails.setMessage(amountException.getMessage());
        errorDetails.setDetails(webRequest.getDescription(false));

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
