package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidNameSizeException extends RuntimeException {
    public InvalidNameSizeException() {
        super(Constants.INVALID_NAME_SIZE_MESSAGE);
    }
}
