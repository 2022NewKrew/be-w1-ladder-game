package ladderGame.exception;

import ladderGame.exception.ladderException.LadderGameException;
import ladderGame.util.ResourceManager;

public class ExceptionHandler {
    public static void handle(LadderGameException ladderGameException) {
        System.out.println(ladderGameException.getMessage());
        System.out.println("비정상적인 동작으로 프로그램을 종료합니다.");
        ResourceManager.close();
    }
}
