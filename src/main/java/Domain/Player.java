package Domain;

public class Player {
    private String name;

    public Player(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5글자 이하여야 합니다!");
        }
        this.name = name;
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public String toString() {
        return name;
    }
}
