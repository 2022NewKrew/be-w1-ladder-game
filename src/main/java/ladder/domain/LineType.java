package ladder.domain;

public enum LineType {
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-----"),
    EMPTY_LINE("     ");

    private final String value;

    LineType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
