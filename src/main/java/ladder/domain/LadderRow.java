package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final int ladderWidth;
    private final List<LadderCell> row;

    public LadderRow(int ladderWidth) {
        this.ladderWidth = ladderWidth;
        this.row = new ArrayList<>();

        createLadderRow();
    }

    private void createLadderRow() {
        LineType previousLineType = LineType.EMPTY_LINE;

        for (int i = 0; i < ladderWidth - 1; i++) {
            LadderCell ladderCell = new LadderCell(previousLineType);
            row.add(ladderCell);

            previousLineType = ladderCell.getLine();
        }
    }

    public List<LadderCell> getRow() {
        return row;
    }
}
