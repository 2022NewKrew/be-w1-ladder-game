package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValue;

public class Member extends AbstractStringValue {
    public static final int WIDTH = 5;
    public static final String MSG_ALLOWED_CHAR = "영문 대소문자와 숫자";
    private static final String ALPHA_NUMBER_REGEX = "[a-zA-Z0-9]+";

    public Member(final String member) {
        super(member, WIDTH, ALPHA_NUMBER_REGEX);
    }
}
