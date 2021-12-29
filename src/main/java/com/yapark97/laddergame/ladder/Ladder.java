package com.yapark97.laddergame.ladder;

public class Ladder {
    private final int maxHeight;
    private final LadderRow[] ladderRows;

    public Ladder(int participantsNum, int maxHeight) {
        this.maxHeight = maxHeight;

        ladderRows = new LadderRow[maxHeight];
        for (int i=0; i<maxHeight; i++) {
            ladderRows[i] = new LadderRow(participantsNum);
        }
    }

    public void printLadder() {
        for (int i=0; i<maxHeight; i++) {
            ladderRows[i].printRow();
        }
    }
}
