package laddergame;

import laddergame.domain.Ladder;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGame {
    private final int numberOfPlayer;
    private final int ladderHeight;
    private final Ladder ladder;

    public LadderGame(int numberOfPlayer, int ladderHeight, Ladder ladder) {
        this.numberOfPlayer = numberOfPlayer;
        this.ladderHeight = ladderHeight;
        this.ladder = ladder;
    }

    public static LadderGame of(int numberOfPlayer, int ladderHeight) {
        Ladder ladder = Ladder.of(numberOfPlayer, ladderHeight);
        return new LadderGame(numberOfPlayer, ladderHeight, ladder);
    }

    public static int inputNumberOfPlayer(InputView inputView) {
        return inputView.inputNumberOfPlayer();
    }

    public static int inputLadderHeight(InputView inputView) {
        return inputView.inputLadderHeight();
    }

    public void printLadder(OutputView outputView) {
        outputView.printLadder(ladder);
    }
}
