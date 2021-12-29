package com.yapark97.laddergame.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int maxHeight;
    private final List<LadderRow> ladderRows;

    public Ladder(List<String> participants, int maxHeight) {
        this.maxHeight = maxHeight;

        ladderRows = new ArrayList<>(maxHeight);
        for (int i=0; i<maxHeight; i++) {
            ladderRows.add(new LadderRow(participants.size()));
        }
    }

    public void printLadder() {
        for (int i=0; i<maxHeight; i++) {
            ladderRows.get(i).printRow();
        }
    }
}
