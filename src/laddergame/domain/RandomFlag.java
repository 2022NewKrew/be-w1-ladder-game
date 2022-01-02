package laddergame.domain;

import java.util.Random;

public class RandomFlag {
    private static Random random = new Random();

    private RandomFlag() {
    }

    public static Boolean getRandomFlag() {
        return random.nextBoolean();
    }
}