package ladder.controller;

import ladder.domain.Ladder;

public class LadderController {
    private final Ladder ladder;

    public LadderController(int countOfPerson, int ladderHeight) {
        this.ladder = Ladder.makeLadder(countOfPerson,ladderHeight);
    }

    public Ladder getLadder() {
        return ladder;
    }
}