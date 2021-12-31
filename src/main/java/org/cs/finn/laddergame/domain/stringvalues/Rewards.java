package org.cs.finn.laddergame.domain.stringvalues;

import org.cs.finn.laddergame.domain.AbstractStringValues;
import org.cs.finn.laddergame.util.Separator;

import java.util.List;

public class Rewards extends AbstractStringValues<Reward> {
    public static final String SEPARATOR = Members.SEPARATOR;
    public static final List<Reward> DEFAULT_REWARD_LIST = List.of(new Reward("X"), new Reward("O"), new Reward("X"));
    public static final int INIT = DEFAULT_REWARD_LIST.size();
    public static final int MIN = Members.MIN;
    public static final int MAX = Members.MAX;

    private static final Reward DEFAULT_REWARD = new Reward("X");

    public Rewards(final String rewards, final int requestSize)
    {
        super(Separator.splitString(rewards, SEPARATOR), INIT, MIN, MAX);
        adjustListSize(requestSize, DEFAULT_REWARD);
    }

    @Override
    public Reward generateValue(final String reward) {
        if (reward == null) {
            throw new RuntimeException("reward String is null!");
        }
        return new Reward(reward);
    }

    public static Rewards getDefault(final int requestSize) {
        if (requestSize <= 0) {
            throw new RuntimeException("requestSize is not positive integer! - " + requestSize);
        }
        return new Rewards(getDefaultGenerator(DEFAULT_REWARD_LIST, SEPARATOR), requestSize);
    }
}
