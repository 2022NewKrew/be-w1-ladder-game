package common.value;

public class Player {

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(name + " : Player 이름은 최대 5자입니다~");
        }
    }
}