package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int numberOfPlayers;
    private final int maxLadderHeight;

    private final List<LadderRow> ladderRows;

    public Ladder(List<Player> players, int maxLadderHeight) {
        this.numberOfPlayers = players.size();
        this.maxLadderHeight = maxLadderHeight;
        this.ladderRows = new ArrayList<>();

        createLadder();
    }

    private void createLadder() {
        for (int i = 0; i < maxLadderHeight; i++) {
            ladderRows.add(createLadderRow());
        }
    }

    private LadderRow createLadderRow() {
        return new LadderRow(numberOfPlayers);
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }
}
