package ladder.domain.bridge;

import java.util.Random;

public class RandomBridgeProviderImpl implements RandomBridgeProvider {

    private final Random random;

    public RandomBridgeProviderImpl(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public boolean isConnectableBridgeByRandom() {
        return random.nextBoolean();
    }
}
