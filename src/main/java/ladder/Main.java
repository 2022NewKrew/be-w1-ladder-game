package ladder;

import ladder.domain.LadderGame;
import ladder.view.LadderGamePrinter;

public class Main {
    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        LadderGamePrinter printer = new LadderGamePrinter(" ", "-", "|");
        printer.printLadderGame(game);
    }
}
