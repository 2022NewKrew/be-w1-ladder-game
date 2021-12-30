package laddergame.domain;

public class User {

    private final String name;
    private final static Integer MAX_LENGTH_USER_NAME = 5;

    public User(String name) {
        validateUserNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateUserNameLength(String name) {
        if (name.length() > MAX_LENGTH_USER_NAME) {
            throw new IllegalArgumentException("사람의 이름은 최대 " + MAX_LENGTH_USER_NAME + "자입니다.");
        }
    }
}
