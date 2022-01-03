package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Players {

    public static final String COUNT_OF_PEOPLE_NOT_ZERO = "사다리는 비어있을 수 없습니다.";

    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players valueOf(String[] playerNames) {
        final List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        return new Players(players);
    }

    private void validate(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException(COUNT_OF_PEOPLE_NOT_ZERO);
        }
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    public int size() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }

    public Player get(String name) {
        return players.stream()
            .filter(player -> player.equalsName(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
    }
}
