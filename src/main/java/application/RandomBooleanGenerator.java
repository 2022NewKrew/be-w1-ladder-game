package application;

import java.util.Random;

public class RandomBooleanGenerator {
    private static boolean previousTrueFlag = false;
    private static final Random RANDOM = new Random();

    public static boolean getRandomBoolean() {
        if (previousTrueFlag) {
            previousTrueFlag = false;
            return false;
        }
        previousTrueFlag = RANDOM.nextBoolean();
        return previousTrueFlag;
    }
}
