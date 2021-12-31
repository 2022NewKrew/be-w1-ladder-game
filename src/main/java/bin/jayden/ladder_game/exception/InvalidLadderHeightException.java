package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidLadderHeightException extends RuntimeException {
    public InvalidLadderHeightException() {
        super(Constants.INVALID_LADDER_HEIGHT_MESSAGE);
    }
}
