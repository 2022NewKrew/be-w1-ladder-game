package common.value;

public enum DirectionType {

    LEFT('L'), DOWN('D'), RIGHT('R');

    private final char value;

    DirectionType(char value) {
        this.value = value;
    }

    public char getDirection() { return value; }
}
