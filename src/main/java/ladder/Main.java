package ladder;

import ladder.domain.LadderGame;
import ladder.view.LadderGamePrinter;

public class Main {
    private static final String EMPTY_STEP_STR = " ";
    private static final String FILLED_STEP_STR = "-";
    private static final String POLE_STR = "|";

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        LadderGamePrinter printer = new LadderGamePrinter(EMPTY_STEP_STR, FILLED_STEP_STR, POLE_STR);
        printer.printLadderGame(game);
    }
}
