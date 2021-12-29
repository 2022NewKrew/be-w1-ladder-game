package ladder.controller;

import ladder.domain.Ladder;

public class LadderController {

    private final Ladder ladder;

    public LadderController(int ladderCount, int personCount) {
        int rowCount = ladderCount;
        int columnCount = personCount - 1;
        ladder = new Ladder(rowCount, columnCount);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
