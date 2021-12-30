package com.kakao.domain.player;

public class Player {

    private final Name name;

    private Player(String originalName) {
        this.name = new Name(originalName);
    }

    public static Player create(String name) {
        return new Player(name);
    }

    public String getRefinedName() {
        return name.refine();
    }
}
