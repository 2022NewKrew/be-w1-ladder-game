package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int numOfPeople, int height) {
        if (numOfPeople < 1 || height < 1) {
            throw new IllegalArgumentException();
        }
        createLines(height, numOfPeople);
    }

    private void createLines(int height, int numOfPeople) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(numOfPeople);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
