package domain;

public class User {
    private final String name;
    private int row;
    private int col;

    public User(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public String getName() {
        return name;
    }
}
