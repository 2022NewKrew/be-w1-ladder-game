package laddergame.domain;

public class User {

    private final String name;

    public User(String name) {
        validateUserNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateUserNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사람의 이름은 최대 5자입니다.");
        }
    }
}
