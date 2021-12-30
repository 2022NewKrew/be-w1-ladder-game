package com.kakao.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

class LadderTest {
    String[] testPlayers = { "this", "is", "test" };
    String[] testRewards = { "1000", "꽝", "3000" };
    int ladderTestHeight = 5;
    RandomStrategy<Boolean> randomStrategy = new RandomStrategyOfBoolean();

    Ladder generateSampleLadder () {
        Ladder ladder = new Ladder(testPlayers,testRewards,ladderTestHeight, randomStrategy);
        return ladder;
    }

    @Test
    void getBridgeOfLadder() {
        Ladder ladder = generateSampleLadder();

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

    @Test
    void getGamePlayers() {
        Ladder ladder = generateSampleLadder();

        String[] players = ladder.getGamePlayers();
        assertThat(players)
                .isEqualTo(testPlayers);
    }
}