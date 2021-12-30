package ladder;

import ladder.domain.LadderGame;
import ladder.view.LadderPrinter;

public class Main {
    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        LadderPrinter printer = new LadderPrinter();
        printer.printLadderGame(game);
    }
}
