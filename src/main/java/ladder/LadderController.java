package ladder;

import ladder.domain.Ladder;

public class LadderController {

    private final Ladder ladder;

    public LadderController(int countOfPerson, int ladderHeight) {
        ladder = Ladder.valueOf(countOfPerson, ladderHeight);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
