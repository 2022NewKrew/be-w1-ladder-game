package main.domain.ladder;

import main.domain.connector.RandomConnector;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(String[] players, int ladderHeight) {
        this.ladder = new Ladder(players, ladderHeight, new RandomConnector());
    }

    public void start() {
        ladder.make();
        ladder.print();
    }
}
