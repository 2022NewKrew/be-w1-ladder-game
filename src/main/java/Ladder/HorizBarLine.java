package Ladder;

public class HorizBarLine {
    private final char [] line;

    //클래스 내 상수들
    private static final char HOR_BAR = '-';
    private static final char BLANK = ' ';
    private static final double UPPERBOUND = 0.3;

    public HorizBarLine(int width) {
        line = new char [width];

        for (int i = 0; i< width; i++) {
            setCell(i);
        }
    }

    private void setCell(int idx) {
        line[idx] = BLANK;

        if (Math.random() < UPPERBOUND) {
            line[idx] = HOR_BAR;
        }
    }

    public char[] getLine() {
        return line;
    }
}
