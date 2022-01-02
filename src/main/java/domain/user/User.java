package domain.user;

import domain.user.dto.UserDto;

import static constant.Constants.MAX_LENGTH_OF_NAME;

public class User {

    private final String name;
    private final int number;

    public User(UserDto userDto) {
        this.name = initializeName(userDto.getName());
        this.number = userDto.getNumber();
        validateName();
    }

    private String initializeName(String name) {
        return name.trim();
    }

    private void validateName() {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalStateException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean isNotEmptyName() {
        return !name.isEmpty();
    }

    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.printf("%-" + MAX_LENGTH_OF_NAME + "s ", name);
    }
}
