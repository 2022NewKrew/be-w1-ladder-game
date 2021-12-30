package domain;

public class User {
    private final String name;
    private int location;

    public User(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }
}
