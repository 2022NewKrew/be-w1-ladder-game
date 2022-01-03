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

    int play(int startIndex) {
        int currentIndex = startIndex;

        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public List<Line> getLadder() {
        return lines;
    }
}
