package com.kakao.domain;

import java.util.*;

class Step {

    private static final Random random = new Random();
    private final Boolean step;

    Step(Boolean bool) {
        this.step = setStep(bool);
    }

    Boolean isStep() {
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
