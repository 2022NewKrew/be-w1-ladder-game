package main.view;

import main.domain.ladder.Ladder;
import main.domain.ladder.LadderFactory;
import main.domain.ladder.RandomLadderFactory;
import main.domain.vo.LadderInput;

public class LadderGame {

    private final LadderFactory factory;
    private final LadderPrinter ladderPrinter;

    public LadderGame(LadderInput input) {
        this.factory = new RandomLadderFactory();
        Ladder ladder = factory.createLadder(input.getPlayerNames(), input.getResults(), input.getHeight());
        this.ladderPrinter = new LadderPrinter(ladder);
    }

    public void start() {
        ladderPrinter.printLadder();
        ladderPrinter.printResult();
    }
}
