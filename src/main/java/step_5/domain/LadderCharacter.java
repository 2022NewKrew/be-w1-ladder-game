package step_5.domain;

public enum LadderCharacter {
    POLE("|"),
    CONNECTED("-"),
    NOT_CONNECTED(" "),
    ONE_SPACE(" "),
    NEW_LINE("\n");

    private String value;

    LadderCharacter(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
