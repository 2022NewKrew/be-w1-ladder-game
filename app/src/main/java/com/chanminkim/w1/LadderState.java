package com.chanminkim.w1;

public enum LadderState {
    EMPTY(" "),
    VERTICAL("|"),
    HORIZONTAL("-");

    private final String value;

    LadderState(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
