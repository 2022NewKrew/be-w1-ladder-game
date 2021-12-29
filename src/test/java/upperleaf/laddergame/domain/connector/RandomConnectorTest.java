package upperleaf.laddergame.domain.connector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.game.GameStartInfo;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomConnectorTest {

    final List<String> players = List.of("p1","p2","p3","p4");
    final int MAX_LADDER_HEIGHT = 5;
    final int RANDOM_VALUE = 1;

    RandomConnector connector;
    Ladder ladder;

    @BeforeEach
    void fixture() {
        ladder = new Ladder(new GameStartInfo(players, MAX_LADDER_HEIGHT));
        connector = new RandomConnector(createRandom(RANDOM_VALUE));
    }

    @DisplayName("RandomConnector가 Line과 Height을 랜덤하게 생성하여 연결하면, Ladder가 연결되어야 한다.")
    @Test
    void randomConnectorTest() {
        assertTrue(ladder.isConnectableToRight(RANDOM_VALUE, RANDOM_VALUE));

        connector.connect(ladder);

        assertFalse(ladder.isConnectableToRight(RANDOM_VALUE, RANDOM_VALUE));
        assertTrue(ladder.isRightConnected(RANDOM_VALUE, RANDOM_VALUE));
    }

    private Random createRandom(int value) {
        return new Random() {
            @Override
            public int nextInt() {
                return value;
            }

            @Override
            public int nextInt(int bound) {
                return value;
            }
        };
    }
}