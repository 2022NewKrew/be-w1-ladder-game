package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getRows() {
        return Collections.unmodifiableList(lines);
    }

    public int getLadderHeight() {
        return lines.size();
    }

    public boolean canMoveLeft(int row, int col) {
        return lines.get(row).existLeftBridge(col);
    }

    public boolean canMoveRight(int row, int col) {
        return lines.get(row).existRightBridge(col);
    }
}