package org.cs.finn.laddergame.domain;

import org.cs.finn.laddergame.util.Checker;
import org.cs.finn.laddergame.util.Separator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Members {
    public static final String SEPARATOR = ",";
    public static final List<Member> DEFAULT_MEMBER = List.of(new Member("Ryan"), new Member("Con"), new Member("Muzi"));
    public static final int INIT = DEFAULT_MEMBER.size();
    public static final int MIN = 2;
    public static final int MAX = 10;

    private final List<Member> members;

    public Members(final String members)
            throws IllegalArgumentException
    {
        Checker.checkIntMinMaxInit(INIT, MIN, MAX);
        if (members == null) {
            throw new RuntimeException("memberString is null!");
        }

        final String[] memberArray = Separator.splitString(members, SEPARATOR);
        final List<Member> memberList = cvtStrArrToFilteredMemberList(memberArray);
        if (memberList.size() < MIN || memberList.size() > MAX) {
            throw new IllegalArgumentException("Valid member value is less then " + MIN + " or greater then " + MAX);
        }

        this.members = memberList;
    }

    private List<Member> cvtStrArrToFilteredMemberList(final String[] memberArray) {
        final List<Member> list = new ArrayList<>();
        for (String memberStr : memberArray) {
            addValidMemberLimitByMax(list, memberStr);
        }

        return list;
    }

    private void addValidMemberLimitByMax(final List<Member> list, final String memberStr) {
        if (list.size() > MAX) {
            return;
        }

        try {
            list.add(new Member(memberStr));
        } catch (IllegalArgumentException ignored) {}
    }

    public static Members getDefault() {
        String[] arr = Arrays.stream(DEFAULT_MEMBER.toArray(new Member[0]))
                .map(Member::toString)
                .toArray(String[]::new);

        return new Members(String.join(SEPARATOR, arr));
    }

    public List<Member> getMemberList() {
        return Collections.unmodifiableList(members);
    }
}
