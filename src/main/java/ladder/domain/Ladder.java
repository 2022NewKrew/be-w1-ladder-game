package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = new ArrayList<>(lines);
    }

    private void validate(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이는 0이 될 수 없습니다.");
        }
    }

    public static Ladder valueOf(int countOfPerson, int ladderHeight) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.valueOf(countOfPerson));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
