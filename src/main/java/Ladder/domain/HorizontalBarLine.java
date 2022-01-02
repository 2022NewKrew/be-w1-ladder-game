package Ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class HorizontalBarLine {
    private final List<String> line;

    //클래스 내 상수들
    private static final String HOR_BAR = "-----";
    private static final String BLANK = "     ";
    private static final double UPPERBOUND = 0.3;

    public HorizontalBarLine(int width) {
        line = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            setCell();
        }
    }

    private void setCell() {
        if (line.size() > 0 && HOR_BAR.equals(line.get(line.size() - 1))) {
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
