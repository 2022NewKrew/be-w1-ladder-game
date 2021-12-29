import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(LadderInfo info) {
        ladderRows = makeLadders(info);
    }

    private List<LadderRow> makeLadders(LadderInfo info) {
        List<LadderRow> ladderRows = new ArrayList<>();
        for (int i = 0; i < info.height; i++) {
            LadderRow lineData = new LadderRow(info.width);
            ladderRows.add(lineData);
        }
        return ladderRows;
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }
}
