package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> line;

    Line(List<Boolean> line) {
        if (line == null)
            throw new IllegalArgumentException();
        this.line = Collections.unmodifiableList(line);
    }

    public List<Boolean> getLine() {
        return line;
    }
}