package ladder.domain;

import ladder.exception.IllegalPlayerNameException;

public class Player {

    private static final int MIN_USER_NAME_LENGTH = 1;

    private final String name;
    private final int maxUserNameLength;

    public Player(String name, int maxUserNameLength) {
        this.name = name;
        this.maxUserNameLength = maxUserNameLength;
        validatePlayerName(name);
    }

    private void validatePlayerName(String name) {
        if (name.length() > maxUserNameLength) {
            throw new IllegalPlayerNameException("참가자의 이름은 " + maxUserNameLength + "글자까지 입력할 수 있습니다.");
        }

        if (name.length() < MIN_USER_NAME_LENGTH) {
            throw new IllegalPlayerNameException("참가자의 이름은 최소 1글자 이상이어야 합니다.");
        }

        if (name.equals(" ")) {
            throw new IllegalPlayerNameException("참가자의 이름은 공백일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return this.name.length();
    }

    @Override
    public String toString() {
        return name;
    }
}
