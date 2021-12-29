package ladder;

public enum LadderComponent {
    VERTICAL('|'),
    HORIZONTAL('-'),
    EMPTY(' ');

    private final Character value;

    LadderComponent(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }
}
