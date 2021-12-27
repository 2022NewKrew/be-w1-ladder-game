package ladder.util;

import java.util.Random;

public class RandomUtil {
    private static final Random random = new Random();

    public RandomUtil() {
    }

    public static boolean generateBoolean(){
        return random.nextBoolean();
    }
}
