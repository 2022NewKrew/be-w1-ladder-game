package step2LadderGame.exception.ladderException;

public class TypeMissMatchException extends LadderGameException {
    public TypeMissMatchException() {
        super("변환 타입이 올바르지 않습니다.");
    }
}
