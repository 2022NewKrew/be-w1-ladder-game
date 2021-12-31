package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValues;
import org.cs.finn.laddergame.util.Separator;

import java.util.List;

public class Members extends AbstractStringValues<Member> {
    public static final String SEPARATOR = ",";
    public static final List<Member> DEFAULT_MEMBER_LIST = List.of(new Member("Ryan"), new Member("Con"), new Member("Muzi"));
    public static final int INIT = DEFAULT_MEMBER_LIST.size();
    public static final int MIN = 2;
    public static final int MAX = 10;

    public Members(final String members)
            throws IllegalArgumentException
    {
        super(Separator.splitString(members, SEPARATOR), INIT, MIN, MAX);
    }

    @Override
    public Member generateValue(final String value) {
        if (value == null) {
            throw new RuntimeException("String array is null!");
        }
        return new Member(value);
    }

    public static Members getDefault() {
        return new Members(getDefaultGenerator(DEFAULT_MEMBER_LIST, SEPARATOR));
    }
}
