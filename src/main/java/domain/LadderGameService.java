package domain;

import common.value.Players;
import configuration.LadderGameConfiguration;
import domain.data.GameResult;
import common.value.LadderHeight;
import common.value.PlayerCount;
import domain.value.Ladder;

public class LadderGameService {

    private final LadderGameConfiguration ladderGameConfiguration;

    private final LadderGenerator ladderGenerator;

    public LadderGameService(LadderGameConfiguration ladderGameConfiguration, LadderGenerator ladderGameGenerator) {
        this.ladderGameConfiguration = ladderGameConfiguration;
        this.ladderGenerator = ladderGameGenerator;
    }

    /**
     * 1. 사다리 생성
     *
     */
    public GameResult start() {
        Ladder ladder = generateLadder();
        return new GameResult(ladderGameConfiguration.getPlayers(), ladder);
    }

    private Ladder generateLadder() {
        LadderHeight maxLadderHeight = ladderGameConfiguration.getMaxLadderHeight();
        Players players = ladderGameConfiguration.getPlayers();

        return ladderGenerator.generate(
                maxLadderHeight,
                new PlayerCount(players.getCount())
        );
    }
}
