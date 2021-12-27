package ladder.domain;

import java.util.ArrayList;

public class LineGenerator {

    private final ArrayList<String> line;

    // 객체 생성
    public LineGenerator(ArrayList<String> line) {
        this.line = line;
    }

    // | - | - |
    public static ArrayList MakeLine(int n) {
        ArrayList<String> temp = new ArrayList<>();
        for (int j = 0; j < n - 1; j++) {
            temp.add("|");
            String crossLine = (Math.random() > 0.7) ? "-" : " ";
            temp.add(crossLine);
        }
        temp.add("|");
        return temp;
    }

    public ArrayList<String> getLine() {
        return line;
    }
}
