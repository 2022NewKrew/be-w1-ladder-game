package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<List<LadderComponent>> ladder;

    public Ladder(int userCount, int ladderCount) {
        this.ladder = makeLadder(userCount, ladderCount);
    }

    public List<List<LadderComponent>> makeLadder(int userCount, int ladderCount) {
        List<List<LadderComponent>> ladder = new ArrayList<>();

        for (int i = 0; i < ladderCount; i++) {
            ladder.add(makeLadderRow(userCount));
        }
        return ladder;
    }

    private List<LadderComponent> makeLadderRow(int userCount) {
        List<LadderComponent> ladderRow = new ArrayList<>();
        Boolean hasLeftHorizon = false;

        for (int i = 0; i < userCount; i++) {
            Boolean isEndVertical = i == userCount - 1;
            ladderRow.add(new LadderComponent(isEndVertical, hasLeftHorizon));
            hasLeftHorizon = ladderRow.get(ladderRow.size() - 1).hasRightHorizon();
        }

        return ladderRow;
    }

    public List<List<LadderComponent>> getLadder() {
        return ladder;
    }
}
