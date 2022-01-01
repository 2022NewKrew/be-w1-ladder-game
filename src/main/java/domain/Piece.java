package domain;

public enum Piece {
    EMPTY(" "),
    VERTICAL("|"),
    HORIZONTAL("-");

    private final String value;

    Piece(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
