package ladder;

import java.util.Random;

public class RandomBridgeManger {

    private final Random random;

    public RandomBridgeManger(long seed) {
        this.random = new Random(seed);
    }

    public boolean isConnectableBridgeByRandom() {
        return random.nextBoolean();
    }
}
