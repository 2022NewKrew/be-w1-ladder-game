package laddergame;

import laddergame.domain.Ladder;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    private final int numberOfGamer;
    private final int ladderHeight;
    private final Ladder ladder;

    public LadderGame(int numberOfGamer, int ladderHeight, Ladder ladder) {
        this.numberOfGamer = numberOfGamer;
        this.ladderHeight = ladderHeight;
        this.ladder = ladder;
    }

    public static LadderGame of(int numberOfGamer, int ladderHeight) {
        Ladder ladder = Ladder.of(numberOfGamer, ladderHeight);
        return new LadderGame(numberOfGamer, ladderHeight, ladder);
    }

    public static int inputNumberOfGamer() {
        return InputView.inputNumberOfGamer();
    }

    public static int inputLadderHeight() {
        return InputView.inputLadderHeight();
    }

    public void printLadder() {
        OutputView.printLadder(ladder);
    }
}
