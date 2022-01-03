package com.kakao.model;

import com.kakao.exception.PlayerFormatException;
import com.kakao.exception.RewardFormatException;
import com.kakao.random.RandomStrategy;
import com.kakao.random.RandomStrategyOfBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LadderTest {
    String[] samplePlayers = new String[]{"this", "is", "test"};
    String[] sampleRewards = new String[]{"1000", "꽝", "3000"};
    int ladderTestHeight = 5;
    RandomStrategy<Boolean> randomStrategy = new RandomStrategyOfBoolean();

    Ladder generateSampleLadder (String[] players, String[] rewards) {
        GamePlayers gamePlayers = null;
        GameRewards gameRewards = null;
        try {
            gamePlayers = new GamePlayers(players);
            gameRewards = new GameRewards(rewards, gamePlayers.getNumberOfPlayers());
        } catch (PlayerFormatException | RewardFormatException e){
            e.printStackTrace();
        }
        Ladder ladder = new Ladder(gamePlayers,gameRewards,ladderTestHeight, randomStrategy);
        return ladder;
    }

    @Test
    @DisplayName("플레이어는 null이 될 수 없다")
    void 플레이어가_NULL인_경우() {
        String[] testPlayers = null;
        String[] testRewards = sampleRewards;
        Ladder ladder = generateSampleLadder(testPlayers, testRewards);

        List<List<Boolean>> result = ladder.getBridgeOfLadder();
        assertThat(result)
                .isNotEmpty()
                .hasSize(ladderTestHeight);

        for(List<Boolean> row : result) {
            assertThat(row)
                    .isNotEmpty()
                    .hasSize(testPlayers.length - 1)
                    .hasOnlyElementsOfType(Boolean.class);
        }
    }
}