package domain;

import java.util.Random;

public class RandomController {
    private final Random random;
    public RandomController(){ random = new Random(); }

    public boolean getRandomBoolean(){ return random.nextBoolean(); }
}
