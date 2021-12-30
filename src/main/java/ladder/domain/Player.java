package ladder.domain;

import ladder.exception.IllegalPlayerNameException;

public class Player {

    private static final int MAX_USER_NAME_LENGTH = 5;
    private static final int MIN_USER_NAME_LENGTH = 1;

    private final String name;

    public Player(String name) {
        this.name = name;
        validatePlayerName(name);
    }

    private void validatePlayerName(String name) {
        if (name.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalPlayerNameException("참가자의 이름은 5글자까지 입력할 수 있습니다.");
        }

        if (name.length() < MIN_USER_NAME_LENGTH) {
            throw new IllegalPlayerNameException("참가자의 이름은 최소 1글자 이상이어야 합니다.");
        }

        if (name.equals(" ")) {
            throw new IllegalPlayerNameException("참가자의 이름은 공백일 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return this.name + " ".repeat((MAX_USER_NAME_LENGTH - name.length()) / 2);
    }
}
