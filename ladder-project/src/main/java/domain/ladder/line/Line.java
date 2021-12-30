package domain.ladder.line;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> lines;

    private Line(List<Boolean> lines) {
        this.lines = lines;
    }

    public static Line createToStrategy(LineStrategy lineStrategy, int column) {
        List<Boolean> lines = lineStrategy.createLine(column);
        checkLinePositionValidate(lines);
        return new Line(lines);
    }

    private static void checkLinePositionValidate(List<Boolean> lines) {
        for (int i = 1; i < lines.size(); i++) {
            checkLeft(lines, i);
        }
    }

    private static void checkLeft(List<Boolean> lines, int position) {
        if (lines.get(position - 1) && lines.get(position)) {
            lines.set(position, false);
        }
    }

    public List<Boolean> getLines() {
        return new ArrayList<>(lines);
    }
}
