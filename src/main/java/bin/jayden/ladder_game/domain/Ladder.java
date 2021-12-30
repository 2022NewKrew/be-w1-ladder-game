package bin.jayden.ladder_game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(int width, int height) {
        ladderRows = makeLadders(width, height);
    }

    private List<LadderRow> makeLadders(int width, int height) {

        List<LadderRow> ladderRows = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            LadderRow ladderRow = new LadderRow(width);
            ladderRows.add(ladderRow);
        }
        return Collections.unmodifiableList(ladderRows);
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }
}
