package ontop.exceptions;

public class BalanceException extends RuntimeException{

    public BalanceException() {
    }

    public BalanceException(String message) {
        super(message);
    }
}
