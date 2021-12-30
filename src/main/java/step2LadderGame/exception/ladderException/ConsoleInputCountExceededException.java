package step2LadderGame.exception.ladderException;

public class ConsoleInputCountExceededException extends LadderGameException{
    public ConsoleInputCountExceededException() {
        super("입력 횟수가 초과 되었습니다.");
    }
}
