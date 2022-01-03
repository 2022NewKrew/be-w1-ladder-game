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

    int move(int idx) {
        if (idx != 0 && line.get(idx - 1))
            return idx - 1;
        if (idx != line.size() && line.get(idx))
            return idx + 1;
        return idx;
    }

    public List<Boolean> getLine() {
        return line;
    }
}