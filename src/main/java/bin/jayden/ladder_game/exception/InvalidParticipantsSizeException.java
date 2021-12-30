package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidParticipantsSizeException extends Exception {
    public InvalidParticipantsSizeException() {
        super(String.format("잘못된 크기의 참가자 수 입니다. (최소 : %d, 최대 : %d)", Constants.MIN_PARTICIPANT_SIZE, Constants.MAX_PARTICIPANT_SIZE));
    }
}
