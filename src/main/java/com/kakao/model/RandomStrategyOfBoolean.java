package com.kakao.model;

import java.util.Random;

public class RandomStrategyOfBoolean implements RandomStrategy<Boolean>{
    private Random random = new Random();

    @Override
    public Boolean random() {
        return random.nextBoolean();
    }
}
