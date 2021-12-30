package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows = new ArrayList<>();

    Ladder(int numOfPeople, int height) {
        for (int i = 0; i < height; ++i) {
            rows.add(new LadderRow(numOfPeople));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow row: rows) {
            sb.append(row);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
