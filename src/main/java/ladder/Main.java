package ladder;

import ladder.domain.GameController;

public class Main {

    private static GameController gameController;

    static public void main(String[] args) throws IllegalArgumentException {
        initialize();
        gameController.startGame();
    }

    private static void initialize() {
        gameController = new GameController();
    }
}
