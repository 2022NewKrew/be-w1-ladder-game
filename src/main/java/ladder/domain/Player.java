package ladder.domain;

public class Player {

    private static final int MAX_USER_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        this.name = name;
        validatePlayerName(name);
    }

    private void validatePlayerName(String name) {
        if (name.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalStateException("참가자의 이름은 5글자까지 입력할 수 있습니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
