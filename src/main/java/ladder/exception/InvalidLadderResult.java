package ladder.exception;

public class InvalidLadderResult extends RuntimeException {
    public InvalidLadderResult(String errorMessage) {
        super(errorMessage);
    }
}
