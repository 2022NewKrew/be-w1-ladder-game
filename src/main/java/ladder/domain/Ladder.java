package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사다리 클래스. {@link LadderRow}의 리스트로 구성되어 있다
 */
public class Ladder {
    private final List<LadderRow> rows = new ArrayList<>();

    public Ladder(int numOfPeople, int height) {
        for (int i = 0; i < height; ++i) {
            rows.add(new LadderRow(numOfPeople));
        }
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
