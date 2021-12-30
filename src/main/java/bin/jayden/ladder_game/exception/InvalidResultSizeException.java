package bin.jayden.ladder_game.exception;

public class InvalidResultSizeException extends Exception {
    public InvalidResultSizeException() {
        super("참가자 수와 결과의 개수가 같지않습니다.");
    }
}
