package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players valueOf(String[] playerNames) {
        final List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        return new Players(players);
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
