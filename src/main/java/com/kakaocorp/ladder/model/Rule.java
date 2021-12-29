package com.kakaocorp.ladder.model;

public class Rule {

    private final int maxNameLength;

    public Rule(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }
}
