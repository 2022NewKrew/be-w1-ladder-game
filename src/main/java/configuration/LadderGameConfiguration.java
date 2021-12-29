package configuration;

import java.util.List;

public class LadderGameConfiguration {

    // 게임의 각각 설정은 게임 시작 후 변경 불가능하다고 가정. 생성자로만 입력받게함.
    private final List<Player> playerList;

    private final LadderHeight maxLadderHeight;

    public LadderGameConfiguration(List<Player> playerList, LadderHeight ladderHeight) {
        this.playerList = playerList;
        this.maxLadderHeight = ladderHeight;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public PeopleCount getPlayerCount() {
        return new PeopleCount(playerList.size());
    }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }
}
