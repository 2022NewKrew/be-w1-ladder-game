package ladderGame;

import ladderGame.domain.Input;
import ladderGame.ladder.LadderGame;

/*
*   게임을 수행시키는 주체가 되는 클래스입니다.
*   게임을 여러번 수행하는 경우를 고려해 분리했습니다.
* */
public class GameStarter {
    public static void main(String[] args) {
        Input.openScanner();

        LadderGame ladderGame = LadderGame.newInstance();
        ladderGame.start();

        Input.closeScanner();
    }
}