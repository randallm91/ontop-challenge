package ontop.exceptions;

public class RecipientAlreadyExistException extends RuntimeException{
    public RecipientAlreadyExistException() {
    }
    public RecipientAlreadyExistException(String message) {
        super(message);
    }
}
