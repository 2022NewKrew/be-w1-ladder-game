package step2.util;

public enum BranchChar {
    USER_LINE('|'), CONNECTED('-'), DISCONNECTED(' ');

    private char ch;
    BranchChar(char c) {
        this.ch = c;
    }

    public char getCh() {
        return ch;
    }
}
