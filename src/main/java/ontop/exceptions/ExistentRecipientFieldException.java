package ontop.exceptions;

public class ExistentRecipientFieldException extends RuntimeException{
    public ExistentRecipientFieldException() {
    }

    public ExistentRecipientFieldException(String message) {
        super(message);
    }
}
