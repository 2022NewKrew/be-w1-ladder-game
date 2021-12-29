package ladder;

import connector.RandomConnector;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(int numOfPlayer, int ladderHeight) {
        this.ladder = new Ladder(numOfPlayer, ladderHeight, new RandomConnector());
    }

    public void start() {
        ladder.make();
        ladder.print();
    }
}
