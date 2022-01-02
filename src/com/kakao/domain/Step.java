package com.kakao.domain;

import java.util.*;

public class Step {

    private static final Random random = new Random();
    private final Boolean step;

    public Step(Boolean bool) {
        this.step = setStep(bool);
    }

    public Boolean isStep() {
        return step;
    }

    private Boolean setStep(Boolean bool) {
        if (bool) {
            return random.nextBoolean();
        }
        return false;
    }

    @Override
    public String toString() {
        if (step) {
            return "-----";
        }
        return "     ";
    }
}
