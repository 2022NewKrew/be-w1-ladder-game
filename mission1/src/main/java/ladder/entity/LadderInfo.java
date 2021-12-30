package ladder.entity;

import ladder.domain.Line;

import java.util.ArrayList;

public class LadderInfo {
    private final ArrayList<Line> ladder;

    public LadderInfo(ArrayList<Line> ladder) {
        this.ladder = ladder;
    }

    public ArrayList<Line> getLadder() {
        return ladder;
    }

}
