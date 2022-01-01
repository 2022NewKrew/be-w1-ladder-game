package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;

    public Ladder(List<LadderLine> ladder) {
        this.ladder = Collections.unmodifiableList(ladder);
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
