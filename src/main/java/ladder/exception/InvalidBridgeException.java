package ladder.exception;

public class InvalidBridgeException extends RuntimeException {
    public InvalidBridgeException() {
        super();
    }

    public InvalidBridgeException(String message) {
        super(message);
    }

    public InvalidBridgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBridgeException(Throwable cause) {
        super(cause);
    }

    protected InvalidBridgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
