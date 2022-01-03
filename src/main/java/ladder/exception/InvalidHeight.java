package ladder.exception;

public class InvalidHeight extends RuntimeException {
    public InvalidHeight(String errorMessage) {
        super(errorMessage);
    }
}
