package com.kakao.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    private RandomUtil() {
    }

    public static Boolean nextBoolean() {
        return random.nextBoolean();
    }
}
