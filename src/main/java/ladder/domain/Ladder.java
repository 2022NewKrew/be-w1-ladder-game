package ladder.domain;

import java.util.ArrayList;

public class Ladder {

    private final int numberOfPlayers;
    private final int maxLadderHeight;

    private final ArrayList<LadderRow> ladderRows;

    public Ladder(int numberOfPlayers, int maxLadderHeight) {
        this.numberOfPlayers = numberOfPlayers;
        this.maxLadderHeight = maxLadderHeight;
        ladderRows = new ArrayList<>();
    }

    public ArrayList<LadderRow> getLadderRows() {
        return ladderRows;
    }

    public void createLadder() {
        for (int i = 0; i < maxLadderHeight; i++) {
            ladderRows.add(createLadderRow());
        }
    }

    private LadderRow createLadderRow() {
        LadderRow ladderRow = new LadderRow(numberOfPlayers);
        ladderRow.createLadderRow();
        return ladderRow;
    }
}
