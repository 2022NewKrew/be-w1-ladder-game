package ladderGame.util;

import java.util.Random;

public final class RandomUtil {
    private static final Random random = new Random();

    private RandomUtil() { }

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
