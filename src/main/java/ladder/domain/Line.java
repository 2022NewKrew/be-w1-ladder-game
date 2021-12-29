package ladder.domain;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> line;

    Line(ArrayList<Boolean> line) {
        this.line = line;
    }

    public ArrayList<Boolean> getLine() {
        return line;
    }
}