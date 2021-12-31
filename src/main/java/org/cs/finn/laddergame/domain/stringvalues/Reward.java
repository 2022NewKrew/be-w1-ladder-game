package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValue;

public class Reward extends AbstractStringValue {
    public static final int WIDTH = Member.WIDTH;
    public static final String MSG_ALLOWED_CHAR = "영문 대소문자와 숫자";
    private static final String ALPHA_NUMBER_REGEX = "[a-zA-Z0-9]+";

    public Reward(final String reward) {
        super(reward, WIDTH, ALPHA_NUMBER_REGEX);
    }
}
