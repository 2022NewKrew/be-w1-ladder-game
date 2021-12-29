package ladder.domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> line;

    Line(ArrayList<Boolean> line) {
        if (line == null)
            throw new IllegalArgumentException();
        this.line = line;
    }

    public ArrayList<Boolean> getLine() {
        return line;
    }
}