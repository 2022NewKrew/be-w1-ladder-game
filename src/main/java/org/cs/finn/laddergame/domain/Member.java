package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.util.Checker;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Member {
    public static final String SEPARATOR = ",";
    public static final List<String> DEFAULT_MEMBER = List.of("Ryan", "Con", "Muzi");
    public static final int INIT = DEFAULT_MEMBER.size();
    public static final int MIN = 2;
    public static final int MAX = 10;
    public static final int WIDTH = 5;
    public static final String MSG_ALLOWED_CHAR = "영문 대소문자와 숫자";
    private static final String ALPHA_NUMBER_REGEX = "[a-zA-Z0-9]+";

    private final List<String> member;

    public Member(final String memberString)
            throws IllegalArgumentException
    {
        Checker.checkIntMinMaxInit(INIT, MIN, MAX);
        if (memberString == null) {
            throw new RuntimeException("memberString is null!");
        }

        String[] members = splitAndFilterValidMember(memberString);
        if (members.length < MIN || members.length > MAX) {
            throw new IllegalArgumentException("Valid member value is less then " + MIN + " or greater then " + MAX);
        }

        member = List.of(members);
    }

    private String[] splitAndFilterValidMember(final String memberString) {
        return Arrays.stream(memberString.split(SEPARATOR))
                .map(String::trim)
                .filter(Predicate.not(String::isBlank))
                .filter((s) -> (s.length() <= WIDTH))
                .filter((s) -> (s.matches(ALPHA_NUMBER_REGEX)))
                .limit(MAX + 1)
                .toArray(String[]::new);
    }

    public static Member getDefault() {
        return new Member(String.join(SEPARATOR, DEFAULT_MEMBER.toArray(new String[0])));
    }

    public List<String> getMember() {
        return member;
    }
}
