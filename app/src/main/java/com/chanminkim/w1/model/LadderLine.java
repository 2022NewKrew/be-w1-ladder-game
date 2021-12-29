package com.chanminkim.w1.model;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<LadderState> states = new ArrayList<>();

    public void appendState(LadderState state) {
        states.add(state);
    }

    public boolean isOccurredBefore() {
        return states.size() > 1
                && states.get(states.size() - 2).equals(LadderState.HORIZONTAL);
    }

    public List<LadderState> getStates() {
        return states;
    }
}
