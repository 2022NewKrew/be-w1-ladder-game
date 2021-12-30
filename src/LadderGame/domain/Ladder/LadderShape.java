package LadderGame.domain.Ladder;

public enum LadderShape {
    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-----"),
    BLANK("     ");

    private final String shape;

    LadderShape(String shape) {
        this.shape = shape;
    }

    public String getShape(){
        return shape;
    }
}
