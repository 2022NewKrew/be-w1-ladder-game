package laddergame;

public class LadderGame {
    private final int numberOfGamer;
    private final int maxHeight;
    private final Ladder ladder;

    public LadderGame() {
        this.numberOfGamer = InputView.inputNumberOfGamer();
        this.maxHeight = InputView.inputLadderHeight();
        this.ladder = new Ladder(numberOfGamer, maxHeight);
    }

    public void printLadder() {
        OutputView.printLadder(ladder.getLineList());
    }
}
