package laddergame;

import laddergame.view.ConsoleInputView;
import laddergame.view.InputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final int numberOfGamer = LadderGame.inputNumberOfGamer(inputView);
        final int ladderHeight = LadderGame.inputLadderHeight(inputView);
        LadderGame ladderGame = LadderGame.of(numberOfGamer, ladderHeight);
        ladderGame.printLadder();
    }
}
