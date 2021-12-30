package ladderGame;

import ladderGame.controller.LadderGameController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        final LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.run();
    }
}
