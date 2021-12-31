package org.cs.finn.laddergame.domain;

public class Member {
    public static final int WIDTH = 5;
    public static final String MSG_ALLOWED_CHAR = "영문 대소문자와 숫자";
    private static final String ALPHA_NUMBER_REGEX = "[a-zA-Z0-9]+";

    private final String member;

    public Member(final String member) {
        if (member == null) {
            throw new RuntimeException("member String is null!");
        }

        validate(member);
        this.member = member;
    }

    private static void validate(final String member) {
        if (member.isBlank()) {
            throw new IllegalArgumentException("member String is blank!");
        }
        if (member.length() > WIDTH) {
            throw new IllegalArgumentException("member String length is longer than limit " + WIDTH);
        }
        if (!member.matches(ALPHA_NUMBER_REGEX)) {
            throw new IllegalArgumentException("Illegal character found in member String!");
        }
    }

    @Override
    public String toString() {
        return member;
    }
}
