package step2.exception;

public class CustomNumberFormatException extends NumberFormatException {
    public CustomNumberFormatException() {
        super("잘못된 타입입니다. 양의 정수를 입력해주세요");
    }
}
