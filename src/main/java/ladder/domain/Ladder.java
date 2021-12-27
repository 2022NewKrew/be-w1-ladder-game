package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder valueOf(int person, int ladder) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladder; i++) {
            lines.add(Line.valueOf(person));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
