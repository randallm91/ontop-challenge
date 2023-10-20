package ontop.exceptions;

public class NullRecipientFieldException extends RuntimeException{

    public NullRecipientFieldException() {
    }

    public NullRecipientFieldException(String message) {
        super(message);
    }
}
