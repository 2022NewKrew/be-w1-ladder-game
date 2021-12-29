package ladder;

enum LadderComponent {
    VERTICAL("|"),
    HORIZONTAL("-----"),
    EMPTY("     "),
    PADDING("   ");

    private final String value;

    LadderComponent(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
