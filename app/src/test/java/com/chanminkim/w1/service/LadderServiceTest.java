package com.chanminkim.w1.service;

import com.chanminkim.w1.model.Ladder;
import com.chanminkim.w1.model.LadderLine;
import com.chanminkim.w1.model.LadderState;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class LadderServiceTest {
    @Test
    public void 만들어진_사다리의_높이는_주어진_높이와_같아야한다() {
        Random random = new Random(0L);
        LadderService service = new LadderService(random);
        int numberOfPlayers = 3;
        int heightOfLadder = 5;
        Ladder ladder = service.buildLadder(numberOfPlayers, heightOfLadder);

        Assert.assertEquals(heightOfLadder, ladder.getLines().size());
    }

    @Test
    public void 만들어진_사다리의_너비는_주어진_플레이어수_곱하기_2_빼기_1_값과_같아야한다() {
        Random random = new Random(0L);
        LadderService service = new LadderService(random);
        int numberOfPlayers = 3;
        int heightOfLadder = 5;
        Ladder ladder = service.buildLadder(numberOfPlayers, heightOfLadder);

        Assert.assertEquals(numberOfPlayers * 2 - 1, getWidthOfLadder(ladder));
    }

    private int getWidthOfLadder(Ladder ladder) {
        return ladder.getLines()
                .get(0)
                .getStates()
                .size();
    }

    @Test
    public void 만들어진_사다리의_너비는_모든_Line이_동일해야한다() {
        Random random = new Random(0L);
        LadderService service = new LadderService(random);
        int numberOfPlayers = 3;
        int heightOfLadder = 5;
        Ladder ladder = service.buildLadder(numberOfPlayers, heightOfLadder);

        Assert.assertEquals(1L, countDistinctWidth(ladder));
    }

    private long countDistinctWidth(Ladder ladder) {
        return ladder.getLines().stream()
                .map(LadderLine::getStates)
                .map(List::size)
                .distinct()
                .count();
    }

    @Test
    public void 만들어진_사다리의_상태에는_NULL이_없어야한다() {
        Random random = new Random(0L);
        LadderService service = new LadderService(random);
        int numberOfPlayers = 3;
        int heightOfLadder = 5;
        Ladder ladder = service.buildLadder(numberOfPlayers, heightOfLadder);

        Assert.assertEquals(0L, getNumberOfNullState(ladder));
    }

    private long getNumberOfNullState(Ladder ladder) {
        return ladder.getLines().stream()
                .map(LadderLine::getStates)
                .flatMap(Collection::stream)
                .filter(Objects::isNull)
                .count();
    }

    @Test
    public void 만들어진_사다리에_연속되는_HORIZONTAL_상태는_없어야한다() {
        Random random = new Random(0L);
        LadderService service = new LadderService(random);
        int numberOfPlayers = 100;
        int heightOfLadder = 100;
        Ladder ladder = service.buildLadder(numberOfPlayers, heightOfLadder);

        boolean consecutive = false;
        for (LadderLine line : ladder.getLines()) {
            if (isConsecutive(line)) {
                consecutive = true;
                break;
            }
        }

        Assert.assertFalse(consecutive);
    }

    private boolean isConsecutive(LadderLine line) {
        List<LadderState> states = line.getStates();
        for (int i = 3; i < states.size(); i += 2) {
            if (states.get(i).equals(LadderState.HORIZONTAL)
                    && states.get(i).equals(states.get(i - 2))) {
                return true;
            }
        }
        return false;
    }
}