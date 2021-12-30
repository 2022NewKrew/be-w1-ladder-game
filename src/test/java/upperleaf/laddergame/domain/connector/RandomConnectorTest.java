package upperleaf.laddergame.domain.connector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.game.GameStartInfo;
import upperleaf.laddergame.game.GameStartInfoFactory;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomConnectorTest {

    final int RANDOM_VALUE = 1;

    RandomConnector connector;
    Ladder ladder;

    @BeforeEach
    void fixture() {
        GameStartInfoFactory infoFactory = new GameStartInfoFactory();
        GameStartInfo info = infoFactory.create();
        ladder = new Ladder(info);
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