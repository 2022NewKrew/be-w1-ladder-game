package com.laddergame;

public class Participant {
    public String name;

    public Participant(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name.length() > NAME_LENGTH_UPPERBOUND) {
            throw new IllegalArgumentException("Name length should not exceed 5");
        }
    }

    private static final int NAME_LENGTH_UPPERBOUND = 5;
}
