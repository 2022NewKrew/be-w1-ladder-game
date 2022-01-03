package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidParticipantsSizeException extends RuntimeException {
    public InvalidParticipantsSizeException() {
        super(Constants.INVALID_PARTICIPANTS_SIZE_MESSAGE);
    }
}
