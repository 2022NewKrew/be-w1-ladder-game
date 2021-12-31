package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValues;
import org.cs.finn.laddergame.util.Separator;

import java.util.List;

public class Rewards extends AbstractStringValues<Reward> {
    public static final String SEPARATOR = ",";
    public static final List<Reward> DEFAULT_REWARD_LIST = List.of(new Reward("X"), new Reward("O"), new Reward("X"));
    public static final int INIT = DEFAULT_REWARD_LIST.size();
    public static final int MIN = 2;
    public static final int MAX = 10;

    public Rewards(final String rewards)
            throws IllegalArgumentException
    {
        super(Separator.splitString(rewards, SEPARATOR), INIT, MIN, MAX);
    }

    @Override
    public Reward generateValue(final String reward) {
        if (reward == null) {
            throw new RuntimeException("reward String is null!");
        }
        return new Reward(reward);
    }

    public static Rewards getDefault() {
        return new Rewards(getDefaultGenerator(DEFAULT_REWARD_LIST, SEPARATOR));
    }
}
