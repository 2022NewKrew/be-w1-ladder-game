package configuration;

import common.value.LadderHeight;
import common.value.Players;

public class LadderGameConfiguration {

    // 게임의 각각 설정은 게임 시작 후 변경 불가능하다고 가정. 생성자로만 입력받게함.
    private final Players players;

    private final LadderHeight maxLadderHeight;

    public LadderGameConfiguration(Players players, LadderHeight ladderHeight) {
        this.players = players;
        this.maxLadderHeight = ladderHeight;
    }

    public Players getPlayers() {
        return this.players;
    }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }

}
