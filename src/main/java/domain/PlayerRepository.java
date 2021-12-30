package domain;

import java.util.List;

public class PlayerRepository {
    private final List<Player> players;

    public PlayerRepository(List<Player> players) {
        this.players = players;
    }
}

