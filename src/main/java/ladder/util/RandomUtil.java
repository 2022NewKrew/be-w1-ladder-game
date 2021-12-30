package ladder.util;

import java.util.Random;

public enum RandomUtil {
    INSTANCE;

    private static final Random random = new Random();

    public boolean generateBoolean() {
        return random.nextBoolean();
    }
}
