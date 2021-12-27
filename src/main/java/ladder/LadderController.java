package ladder;

import ladder.domain.Ladder;

public class LadderController {

    private final Ladder ladder;

    public LadderController(int person, int ladderCount) {
        ladder = Ladder.valueOf(person, ladderCount);
    }

    public Ladder result() {
        return ladder;
    }
}
