package laddergame.domain;

public class Line {
    private Flags flags;

    Line(Flags flags) {
        this.flags = flags;
    }

    public Flag getFlagByIndex(int index) {
        return flags.getFlagByIndex(index);
    }
}