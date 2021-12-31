package domain;

import common.value.Player;
import common.value.Players;
import configuration.LadderGameConfiguration;
import domain.data.Goal;
import domain.data.Goals;
import domain.data.LadderGameResult;
import common.value.LadderHeight;
import common.value.PlayerCount;
import domain.data.ResultTable;

import java.util.HashMap;
import java.util.Map;

public class LadderGameService {

    private final LadderGameConfiguration ladderGameConfiguration;

    private final LadderGenerator ladderGenerator;

    private Ladder ladder;

    public LadderGameService(LadderGameConfiguration ladderGameConfiguration, LadderGenerator ladderGameGenerator) {
        this.ladderGameConfiguration = ladderGameConfiguration;
        this.ladderGenerator = ladderGameGenerator;
    }

    /**
     * 1. 사다리 생성
     *
     */
    public LadderGameResult start() {
        this.ladder = generateLadder();

        ResultTable resultTable = executeLadderGame();

        return new LadderGameResult(
                ladderGameConfiguration.getPlayers(),
                ladder,
                ladderGameConfiguration.getGoals(),
                resultTable
        );
    }

    private Ladder generateLadder() {
        LadderHeight maxLadderHeight = ladderGameConfiguration.getMaxLadderHeight();
        Players players = ladderGameConfiguration.getPlayers();

        return ladderGenerator.generate(
                new PlayerCount(players.getCount()),
                maxLadderHeight
        );
    }

    private ResultTable executeLadderGame() {
        Map<Player, Goal> resultMap = new HashMap<>();
        Players players = ladderGameConfiguration.getPlayers();
        Goals goals = ladderGameConfiguration.getGoals();

        for(int player = 0; player < players.getCount(); player++) {
            int goalIndex = ladder.runToGoal(player);
            resultMap.put(players.getPlayer(player), goals.getGoal(goalIndex));
        }

        return new ResultTable(resultMap);
    }
}
