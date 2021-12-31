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

    public int getNextLineNumber(int currentLine) {
        if (!isLastLine(currentLine) && hasAcrossLine(currentLine)) {
            return currentLine + 1;
        } else if(!isFirstLine(currentLine) && hasAcrossLine(currentLine - 1)) {
            return currentLine - 1;
        }
        return currentLine;
    }

    private boolean hasAcrossLine(int index) {
        return getLineType(index) == LineType.HORIZONTAL_LINE;
    }

    private LineType getLineType(int index) {
        return row.get(index).getLine();
    }

    private boolean isFirstLine(int currentLine) {
        return currentLine == 0;
    }

    private boolean isLastLine(int currentLine) {
        return currentLine == row.size();
    }

    public List<LadderCell> getRow() {
        return row;
    }
}
