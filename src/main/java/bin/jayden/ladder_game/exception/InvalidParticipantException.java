package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidParticipantException extends RuntimeException {
    public InvalidParticipantException() {
        super(Constants.INVALID_PARTICIPANT_MESSAGE);
    }
}
