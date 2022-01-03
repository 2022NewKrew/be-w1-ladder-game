package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {
    private LadderFactory() {
    }

    public static Ladder create(int width, int height) {
        Lines lines = createLines(width, height);
        Ladder ladder = new Ladder(width, height, lines);

        return ladder;
    }

    private static Lines createLines(int width, int count) {
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < count; i++) {
            Line line = LineFactory.create(width);
            lines.add(line);
        }

        return new Lines(lines);
    }
}
