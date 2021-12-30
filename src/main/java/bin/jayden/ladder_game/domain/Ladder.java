package bin.jayden.ladder_game.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(LadderInfo info) {
        ladderRows = makeLadders(info.getWidth(), info.getHeight());
    }

    private List<LadderRow> makeLadders(int width, int height) {
        List<LadderRow> ladderRows = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            LadderRow lineData = new LadderRow(width);
            ladderRows.add(lineData);
        }
        return ladderRows;
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }
}
