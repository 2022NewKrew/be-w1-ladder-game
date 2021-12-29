package common.data;

import common.value.Player;
import service.value.Line;

import java.util.List;

public class GameResult {

    private final List<Player> playerList;

    private final List<Line> ladders;

    public GameResult(List<Player> playerList, List<Line> ladders) {
        this.playerList = playerList;
        this.ladders = ladders;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Line> getLadders() {
        return ladders;
    }
}
