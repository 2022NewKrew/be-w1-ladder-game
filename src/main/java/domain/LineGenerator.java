package domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

    private final List<String> line;

    public LineGenerator(List<String> line) {
        if (line == null) {
            throw new IllegalArgumentException("The UserName cannot be Null");
        }
        this.line = line;
    }

    // | - | - |
    public List<String> MakeLine(int PLAYER_NUM) {
        List<String> temp = new ArrayList<>();
        for (int j = 0; j < PLAYER_NUM - 1; j++) {
            temp.add("|");
            String crossLine = (Math.random() > 0.7) ? "-" : " ";
            temp.add(crossLine);
        }
        temp.add("|");
        return temp;
    }

    public List<String> getLine() {
        return line;
    }
}
