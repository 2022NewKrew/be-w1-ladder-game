package domain;

import validator.Validation;

public class Player {
    private final String name;

    public Player(String name) {
        Validation.validatePlayerName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
