package laddergame;

public class LadderGame {
    private final int numberOfGamer;
    private final int ladderHeight;
    private final Ladder ladder;

    public LadderGame() {
        this.numberOfGamer = InputView.inputNumberOfGamer();
        this.ladderHeight = InputView.inputLadderHeight();
        this.ladder = new Ladder(numberOfGamer, ladderHeight);
    }

    public void printLadder() {
        OutputView.printLadder(ladder.getLineList());
    }
}
