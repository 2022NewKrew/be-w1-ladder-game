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
        boolean previousLadderCell = false;

        for (int i = 0; i < ladderWidth - 1; i++) {
            LadderCell ladderCell = new LadderCell(previousLadderCell);
            row.add(ladderCell);

            previousLadderCell = ladderCell.getLine();
        }
    }

    public List<LadderCell> getRow() {
        return row;
    }
}
