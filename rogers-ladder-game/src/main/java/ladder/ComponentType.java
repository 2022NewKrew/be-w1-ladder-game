package ladder;

public enum ComponentType {
    EMPTY(" "), LINE("|"), LADDER("-"), NONE("");

    private final String shape;

    ComponentType(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
}
