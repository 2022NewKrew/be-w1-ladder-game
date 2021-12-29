package ladder.controller;

import ladder.domain.Ladder;

import java.util.Random;

public class LadderController {

    private final Ladder ladder;

    public LadderController(int ladderCount, int personCount) {
        int rowCount = ladderCount;
        int columnCount = personCount * 2 - 1;
        ladder = new Ladder(rowCount,columnCount);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
