package ontop.exceptions;

public class AccountNumberException extends RuntimeException{

    public AccountNumberException() {
    }

    public AccountNumberException(String message) {
        super(message);
    }
}
