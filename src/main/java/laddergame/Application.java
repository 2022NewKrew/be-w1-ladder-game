package laddergame;

import laddergame.view.ConsoleInputView;
import laddergame.view.ConsoleOutputView;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new ConsoleOutputView();

        final String[] playerNames = LadderGame.inputPlayerNames(inputView);
        final int ladderHeight = LadderGame.inputLadderHeight(inputView);

        LadderGame ladderGame = LadderGame.of(playerNames, ladderHeight);
        ladderGame.printLadder(outputView);
    }
}
