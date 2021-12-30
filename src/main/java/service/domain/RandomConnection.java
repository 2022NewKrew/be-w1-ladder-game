package service.domain;

import service.LadderCharacter;

import java.util.Random;

public class RandomConnection {
    private static final Random random = new Random();
    private static final int connectionRatio = 6;

    public static Boolean randomConnection() {
        return random.nextInt(10) > connectionRatio;
    }
}
