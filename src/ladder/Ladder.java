package ladder;

import java.util.ArrayList;
import java.util.List;

class Ladder {
    private final List<Line> ladderRows;

    public Ladder(int widthOfLadder, int heightOfLadder) {
        ladderRows = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            ladderRows.add(new Line(widthOfLadder));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladderRows.forEach(row -> sb.append(row).append('\n'));
        return sb.toString();
    }
}
