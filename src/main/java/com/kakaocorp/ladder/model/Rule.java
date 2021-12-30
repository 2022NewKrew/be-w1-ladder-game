package com.kakaocorp.ladder.model;

public class Rule {

    private final int maxNameLength;

    private Rule(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public int getMaxNameLength() {
        return maxNameLength;
    }

    public static class Builder {

        private int maxNameLength;

        public Builder maxNameLength(int maxNameLength) {
            this.maxNameLength = maxNameLength;
            return this;
        }

        public Rule build() {
            return new Rule(maxNameLength);
        }
    }
}
