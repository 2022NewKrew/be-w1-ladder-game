package util;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM_INSTANCE = new Random();

    public static boolean getRandomBoolean(){
        return RANDOM_INSTANCE.nextBoolean();
    }
}
