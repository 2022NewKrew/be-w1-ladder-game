package laddergame.domain;

import java.util.List;

public class Lines {
    private List<Line> lines;

    Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Line getLineByIndex(int index) {
        return lines.get(index);
    }
}
