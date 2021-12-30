package step2LadderGame.domain.ladder;

public enum BranchType {
    USER_LINE("|"), CONNECTED("-"), DISCONNECTED(" ");

    private final String str;

    BranchType(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
