package domain;

import java.util.Collections;
import java.util.List;

public class PlayerRepository {
    private final List<Player> players;

    public PlayerRepository(List<Player> players) {
        this.players = Collections.unmodifiableList(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerNums() {
        return players.size();
    }
}
