package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValue;

public class Member extends AbstractStringValue {
    public static final Member NONE = new Member("_none", 5, "[_a-z]+");
    public static final Member TERMINATOR = new Member("_term", 5, "[_a-z]+");
    public static final Member RETRYER = new Member("_retry", 6, "[_a-z]+");
    public static final Member ALL = new Member("all");

    public static final int WIDTH = 5;
    public static final String MSG_ALLOWED_CHAR = "'all'을 제외한 영문 대소문자와 숫자";
    private static final String ALPHA_NUMBER_REGEX = "[a-zA-Z0-9]+";

    public Member(final String member) {
        super(member, WIDTH, ALPHA_NUMBER_REGEX);
    }

    private Member(final String member, final int width, final String regex) {
        super(member, width, regex);
    }

    public boolean isNone() {
        return this.equals(NONE);
    }

    public boolean isTerminator() {
        return this.equals(TERMINATOR);
    }

    public boolean isRetryer() {
        return this.equals(RETRYER);
    }

    public boolean isAll() {
        return this.equals(ALL);
    }
}
