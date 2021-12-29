package service;

import java.util.Random;

public class RandomConnection {
    private static final Random random = new Random();
    private static final int connectionRatio = 6;

    public static String randomConnection() {
        return random.nextInt(10) > connectionRatio ? LadderCharacter.CONNECTED : LadderCharacter.NOT_CONNECTED;
    }
}
