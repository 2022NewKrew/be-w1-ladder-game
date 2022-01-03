package utility;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static boolean getNextBoolean() {
        return random.nextBoolean();
    }

    public static void setSeed(int seed) {
        random.setSeed(seed);
    }
}
