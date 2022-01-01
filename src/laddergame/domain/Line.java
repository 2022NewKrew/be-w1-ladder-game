package laddergame.domain;

public class Line {
    private Flags flags = new Flags();

    Line() {
    }

    public Flag getFlagByIndex(int index) {
        return flags.getFlagByIndex(index);
    }

    void makeLine(int count) {
        flags.makeFlags(count);
    }
}