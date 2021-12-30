package exception;

public class OutOfInputStringException extends RuntimeException {
    public OutOfInputStringException() {
        super();
    }

    public OutOfInputStringException(String message) {
        super(message);
    }

    public OutOfInputStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfInputStringException(Throwable cause) {
        super(cause);
    }

    protected OutOfInputStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
