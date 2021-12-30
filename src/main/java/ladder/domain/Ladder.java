package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows = new ArrayList<>();

    public Ladder(int numOfPeople, int height) {
        for (int i = 0; i < height; ++i) {
            rows.add(new LadderRow(numOfPeople));
        }
    }

    public List<LadderRow> getRows() {
        return rows;
    }
}
