package service;

import configuration.LadderGameConfiguration;
import common.data.GameResult;
import common.value.LadderHeight;
import common.value.Player;
import common.value.PlayerCount;
import service.value.Line;

import java.util.List;

public class LadderGameService {

    private final LadderGameConfiguration ladderGameConfiguration;

    private final LadderGenerator ladderGenerator;

    private List<Line> ladders;

    public LadderGameService(LadderGameConfiguration ladderGameConfiguration, LadderGenerator ladderGameGenerator) {
        this.ladderGameConfiguration = ladderGameConfiguration;
        this.ladderGenerator = ladderGameGenerator;
    }

    public GameResult start() {
        // 현재 게임의 기능은 사다리생성/사다리출력만 있으며,
        // 추가로 게임의 로직이 정해지면 아래에 추가할 것.
        // 1. 사다리 생성
        LadderHeight maxLadderHeight = ladderGameConfiguration.getMaxLadderHeight();
        List<Player> playerList = ladderGameConfiguration.getPlayerList();

        ladders = ladderGenerator.generate(
                maxLadderHeight,
                new PlayerCount(playerList.size())
        );

        return new GameResult(ladderGameConfiguration.getPlayerList(), ladders);
    }
}
