package ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> line;

    Line(List<Boolean> line) {
        if (line == null)
            throw new IllegalArgumentException();
        this.line = line;
    }

    public List<Boolean> getLine() {
        return line;
    }
}