package ladder.exception;

public class InvalidName extends RuntimeException {
    public InvalidName(String errorMessage) {
        super(errorMessage);
    }
}
