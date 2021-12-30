package ladder.domain;

import java.util.Random;

public class RandomBridgeProvider {

    private final Random random;

    public RandomBridgeProvider(long seed) {
        this.random = new Random(seed);
    }

    public boolean isConnectableBridgeByRandom() {
        return random.nextBoolean();
    }
}
