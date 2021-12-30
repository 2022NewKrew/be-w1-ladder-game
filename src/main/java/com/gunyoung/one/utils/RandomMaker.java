package com.gunyoung.one.utils;

import java.util.Random;

public class RandomMaker {
    private Random random;

    public RandomMaker() {
        this(new Random());
    }

    public RandomMaker(Random random) {
        this.random = random;
    }

    public boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
