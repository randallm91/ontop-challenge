package ontop.exceptions;

public class RecipientNotFoundException extends RuntimeException{
    public RecipientNotFoundException() {
    }

    public RecipientNotFoundException(String message) {
        super(message);
    }
}
