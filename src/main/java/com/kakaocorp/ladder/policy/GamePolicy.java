package com.kakaocorp.ladder.policy;

public class GamePolicy {

    private final int maxNameLength;

    public GamePolicy(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }
}
