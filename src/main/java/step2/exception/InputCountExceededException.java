package step2.exception;

public class InputCountExceededException extends RuntimeException{
    public InputCountExceededException() {
        super("입력 횟수가 초과 되어 프로그램이 종료됩니다.");
    }
}
