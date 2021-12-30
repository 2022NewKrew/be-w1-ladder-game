package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.View;

public class LadderGameApplication {

    public static void main(String[] args) {
        try {
            LadderGame ladderGame = new LadderGame(new View());
            ladderGame.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
