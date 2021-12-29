package laddergame;

import laddergame.view.ConsoleInputView;
import laddergame.view.ConsoleOutputView;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new ConsoleOutputView();

        final int numberOfPlayer = LadderGame.inputNumberOfPlayer(inputView);
        final int ladderHeight = LadderGame.inputLadderHeight(inputView);

        LadderGame ladderGame = LadderGame.of(numberOfPlayer, ladderHeight);
        ladderGame.printLadder(outputView);
    }
}
