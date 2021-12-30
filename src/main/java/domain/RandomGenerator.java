package main.java.domain;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();
    private RandomGenerator(){}
    public static int randomInt(){
        return random.nextInt(2);
    }
}
