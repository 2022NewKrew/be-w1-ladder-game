package LadderGame;

public enum LadderShape {
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-----"),
    BLANK("     ");

    private final String shape;

    LadderShape(String components) {
        this.shape = components;
    }

    public String getShape(){
        return shape;
    }
}
