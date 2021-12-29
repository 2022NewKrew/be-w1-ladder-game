package ui.data;

import common.value.LadderHeight;
import common.value.Player;

import java.util.List;

public class UserInputInfo {

    private final List<Player> playerList;

    private final LadderHeight maxLadderHeight;

    public UserInputInfo(List<Player> playerList, LadderHeight maxLadderHeight) {
        this.playerList = playerList;
        this.maxLadderHeight = maxLadderHeight;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }

}
