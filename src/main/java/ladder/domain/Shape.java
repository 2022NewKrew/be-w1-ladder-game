package ladder.domain;

public enum Shape {
    COL("|"),
    ROW("-----"),
    BLANK_ROW("     ");

    private final String shape;

    Shape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
