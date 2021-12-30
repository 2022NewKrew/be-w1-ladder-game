package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidLadderHeightException extends Exception {
    public InvalidLadderHeightException() {
        super(String.format("잘못된 크기의 사다리 높이입니다. (최소 : %d, 최대 : %d)", Constants.MIN_LADDER_HEIGHT, Constants.MAX_LADDER_HEIGHT));
    }
}
