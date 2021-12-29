package com.kakao.domain;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private Player(String name) {
        validate(name);
        this.name = name;
    }

    public static Player create(String name) {
        return new Player(name);
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 비어있거나 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
    }
}
