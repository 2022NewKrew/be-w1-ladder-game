package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValue;

public class Member extends AbstractStringValue {
    public static final Member EMPTY = new Member("lXTlW");
    public static final Member TERMINATOR = new Member("dBB8c");
    public static final Member RETRYER = new Member("Z9mrl");

    public static final int WIDTH = 5;
    public static final String MSG_ALLOWED_CHAR = "영문 대소문자와 숫자";
    private static final String ALPHA_NUMBER_REGEX = "[a-zA-Z0-9]+";

    public Member(final String member) {
        super(member, WIDTH, ALPHA_NUMBER_REGEX);
    }

    public boolean isNotTerminator() {
        return !this.equals(TERMINATOR);
    }

    public boolean isNotRetryer() {
        return !this.equals(RETRYER);
    }
}
