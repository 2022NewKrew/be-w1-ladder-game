package Ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class HorizBarLine {
    private final List<String> line;

    //클래스 내 상수들
    private static final String HOR_BAR = "-----";
    private static final String BLANK = "     ";
    private static final double UPPERBOUND = 0.3;

    public HorizBarLine(int width) {
        line = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            setCell();
        }
    }

    private void setCell() {
        if (line.size() > 0 && line.get(line.size() - 1).equals(HOR_BAR)) {
            line.add(BLANK);
            return;
        }
        if (Math.random() > UPPERBOUND) {
            line.add(BLANK);
            return;
        }

        line.add(HOR_BAR);
    }

    public List<String> getLine() {
        return line;
    }
}
