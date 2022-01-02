package domain.user.dto;

public class UserDto {

    private final String name;
    private final int number;

    public UserDto(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}
