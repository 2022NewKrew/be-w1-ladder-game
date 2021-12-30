package bin.jayden.ladder_game.exception;

import bin.jayden.ladder_game.domain.Constants;

public class InvalidNameSizeException extends Exception {
    public InvalidNameSizeException() {
        super(String.format("잘못된 크기의 이름을 가진 참가자가 존재합니다. (최소 : %d, 최대 : %d)", Constants.MIN_NAME_SIZE, Constants.MAX_NAME_SIZE));
    }
}
