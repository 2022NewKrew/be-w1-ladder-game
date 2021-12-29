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

    public String getStep() {
        if (step) {
            return "----";
        }
        return "    ";
    }

    private Boolean setStep(Boolean bool) {
        if (bool) {
            return random.nextBoolean();
        }
        return false;
    }
}
