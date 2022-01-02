package ladder.exception;

public class NameLengthException extends RuntimeException {
    public NameLengthException(int length) {
        super("플레이어의 이름은 " + length + "글자 미만으로 입력하시오.");
    }
}
