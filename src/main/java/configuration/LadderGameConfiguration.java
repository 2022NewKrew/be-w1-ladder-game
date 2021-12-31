package configuration;

import common.value.LadderHeight;
import common.value.Players;
import domain.data.Goals;

public class LadderGameConfiguration {

    // 게임의 각각 설정은 게임 시작 후 변경 불가능하다고 가정. 생성자로만 입력받게함.
    private final Players players;

    private final Goals goals;

    private final LadderHeight maxLadderHeight;

    public LadderGameConfiguration(Players players, Goals goals, LadderHeight maxLadderHeight) {
        this.players = players;
        this.goals = goals;
        this.maxLadderHeight = maxLadderHeight;
    }

    public Players getPlayers() {
        return players;
    }

    public Goals getGoals() {
        return goals;
    }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }
}
