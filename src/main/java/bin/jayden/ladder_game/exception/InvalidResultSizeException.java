package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidResultSizeException extends RuntimeException {
    public InvalidResultSizeException() {
        super(Constants.INVALID_RESULT_SIZE_MESSAGE);
    }
}
