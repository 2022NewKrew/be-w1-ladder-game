package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//플레이어들 정보
public class Players {
    private List<Player> players;

    public Players(int playerCnt) {
        players = new ArrayList<>(playerCnt);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getPlayersCnt() {
        return players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<String> getPlayersName() {
        List<String> playersName = players.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

        return playersName;
    }
}
