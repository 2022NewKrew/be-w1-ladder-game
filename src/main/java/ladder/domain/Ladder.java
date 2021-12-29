package ladder.domain;

import java.util.ArrayList;

public class Ladder {
    private final ArrayList<Line> lines;

    Ladder(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Line> getLadder() {
        return lines;
    }
}
