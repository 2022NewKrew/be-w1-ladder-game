package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines = new ArrayList<Line>();

    Lines() {
    }

    Line getLineByIndex(int index) {
        return lines.get(index);
    }

    void makeLines(int count, int width) {
        for (int i = 0; i < count; i++) {
            Line line = new Line();
            line.makeLine(width);
            lines.add(line);
        }
    }
}
