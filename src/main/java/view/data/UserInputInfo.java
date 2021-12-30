package view.data;

import common.value.LadderHeight;
import common.value.Player;
import common.value.Players;

import java.util.List;

public class UserInputInfo {

    private final Players players;

    private final LadderHeight maxLadderHeight;

    public UserInputInfo(Players players, LadderHeight maxLadderHeight) {
        this.players = players;
        this.maxLadderHeight = maxLadderHeight;
    }

    public Players getPlayers() {
        return players;
    }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }

}
