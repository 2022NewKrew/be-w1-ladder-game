package view.data;

import common.value.LadderHeight;
import common.value.Players;
import domain.data.Goals;

public class UserInputInfo {

    private final Players players;

    private final Goals ladderResults;

    private final LadderHeight maxLadderHeight;

    public UserInputInfo(Players players, Goals ladderResults, LadderHeight maxLadderHeight) {
        this.players = players;
        this.ladderResults = ladderResults;
        this.maxLadderHeight = maxLadderHeight;
    }

    public Players getPlayers() {
        return players;
    }

    public Goals getLadderResults() {return ladderResults; }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }



}
