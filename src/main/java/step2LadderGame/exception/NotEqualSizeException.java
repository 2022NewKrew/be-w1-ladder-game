package step2LadderGame.exception;

import step2LadderGame.exception.ladderException.LadderGameException;

public class NotEqualSizeException extends LadderGameException {
    public NotEqualSizeException() {
        super("두 리스트 크기가 같지 않습니다.");
    }
}
