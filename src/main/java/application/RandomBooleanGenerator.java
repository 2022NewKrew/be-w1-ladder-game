package application;

import java.util.Random;

public class RandomBooleanGenerator {
    private static final Random RANDOM = new Random();
    private boolean previousTrueFlag = false;

    public boolean getRandomBoolean() {
        if (previousTrueFlag) {
            previousTrueFlag = false;
            return false;
        }
        previousTrueFlag = RANDOM.nextBoolean();
        return previousTrueFlag;
    }
}
