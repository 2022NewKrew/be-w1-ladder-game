package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final int playerCount;
    private final List<String> playerNameList;

    public Player(int playerCount, List<String> playerNameList) {
        this.playerCount = playerCount;
        this.playerNameList = new ArrayList<>(playerNameList);
    }

    public List<String> getPlayerNameList() {
        return playerNameList;
    }
}
