package laddergame.domain;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
