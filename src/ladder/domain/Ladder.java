package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int FIRST_INDEX = 0;

    private final List<LadderRow> ladder;

    public Ladder(List<LadderRow> ladder) {
        this.ladder = ladder;
    }

    public List<LadderRow> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int getLadderHeight() {
        return ladder.size();
    }

    public boolean isPossibleMovingLeft(int row, int col) {
        if (row == FIRST_INDEX) {
            return false;
        }
        return ladder.get(col).isExistBridge(row - 1);
    }

    public boolean isPossibleMovingRight(int row, int col) {
        if (row == ladder.get(0).getLadderRow().size()) {
            return false;
        }
        return ladder.get(col).isExistBridge(row);
    }
}
