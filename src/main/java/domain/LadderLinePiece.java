package domain;

public enum LadderLinePiece {
    EMPTY(" "),
    VERTICAL("|"),
    HORIZONTAL("-")
    ;

    private final String value;

    LadderLinePiece(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
