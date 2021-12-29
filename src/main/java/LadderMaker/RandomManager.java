package LadderMaker;

import java.util.Random;

public class RandomManager {
    private final Random random;
    public RandomManager(){ random = new Random(); }

    public boolean getRandomBoolean(){ return random.nextBoolean(); }
}
