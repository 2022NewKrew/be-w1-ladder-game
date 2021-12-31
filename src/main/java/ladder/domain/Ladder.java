package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int rowCount;
    private final int columnCount;

    public Ladder(int rowCount, int columnCount) {
        this.lines = new ArrayList<>();
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < rowCount; i++) {
            Line line = new Line();
            line.makeLine(columnCount);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int playLadderGame(int playerIndex) {
        int rowIndex = 0;
        int columnIndex = playerIndex;

        while (rowIndex < rowCount) {
            List<Boolean> bridges = lines.get(rowIndex).getBridges();
            columnIndex = move(bridges, columnIndex);
            rowIndex++;
        }
        return columnIndex;
    }

    private int move(List<Boolean> bridges, int columnIndex) {
        if (columnIndex > 0 && bridges.get(columnIndex - 1)) {
            columnIndex--;
        } else if (columnIndex < columnCount && bridges.get(columnIndex)) {
            columnIndex++;
        }
        return columnIndex;
    }
}
