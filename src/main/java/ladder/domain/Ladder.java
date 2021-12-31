package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    Ladder(List<Line> lines) {
        if (lines == null)
            throw new IllegalArgumentException();
        this.lines = Collections.unmodifiableList(lines);
    }

    public List<Line> getLadder() {
        return lines;
    }
}
