package domain.data;

import common.value.Players;
import domain.Ladder;

public class LadderGameResult {

    private final Players players;

    private final Ladder ladder;

    private final Goals goals;

    private final ResultTable resultTable;

    public LadderGameResult(Players players, Ladder ladder, Goals goals, ResultTable resultTable) {
        this.players = players;
        this.ladder = ladder;
        this.goals = goals;
        this.resultTable = resultTable;
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Goals getGoals() {
        return goals;
    }

    public Goal queryResult(String playerName) {
        return resultTable.getGoal(players.getPlayer(playerName));
    }
}
