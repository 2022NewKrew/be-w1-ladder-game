package main.view;

import main.domain.ladder.Ladder;
import main.domain.ladder.LadderFactory;
import main.domain.ladder.RandomLadderFactory;

public class LadderGame {

    private final LadderFactory factory;
    private final LadderPrinter ladderPrinter;

    public LadderGame(String[] players, String[] results, int ladderHeight) {
        this.factory = new RandomLadderFactory();
        Ladder ladder = factory.createLadder(players, results, ladderHeight);
        this.ladderPrinter = new LadderPrinter(ladder);
    }

    public void start() {
        ladderPrinter.print();
    }
}
