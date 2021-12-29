package domain.ladder;

public enum LadderComponent {
    LADDER_ROW_LINE("|"),
    LADDER_EMPTY_COLUMN(" "),
    LADDER_COLUMN_LINE("-");

    private final String value;

    LadderComponent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
