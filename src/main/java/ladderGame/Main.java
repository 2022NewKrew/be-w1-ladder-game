package ladderGame;

import ladderGame.domain.LadderGame;
import ladderGame.domain.RandomLadderIncludeNamesGame;

public class Main {
    public static void main(String[] args) {
//        LadderGame randomLadderGame = new RandomLadderGame();
//        randomLadderGame.start();

        LadderGame randomLadderGame = new RandomLadderIncludeNamesGame();
        randomLadderGame.start();
    }
}
