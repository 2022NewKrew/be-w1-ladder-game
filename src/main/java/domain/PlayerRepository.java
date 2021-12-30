package domain;

import java.util.Collections;
import java.util.List;

public class PlayerRepository {
    private final List<Player> players;

    public PlayerRepository(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}

