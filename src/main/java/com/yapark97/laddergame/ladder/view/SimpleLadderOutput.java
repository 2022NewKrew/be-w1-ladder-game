package com.yapark97.laddergame.ladder.view;

import com.yapark97.laddergame.ladder.domain.Ladder;

public class SimpleLadderOutput implements LadderOutput{
    private final static int WIDTH = 5;
    private static SimpleLadderOutput simpleLadderOutput;

    private SimpleLadderOutput() {}

    public static SimpleLadderOutput getInstance() {
        if (simpleLadderOutput == null) {
            simpleLadderOutput = new SimpleLadderOutput();
        }
        return simpleLadderOutput;
    }

    @Override
    public void drawLadder(Ladder ladder) {
        if (ladder == null) {
            throw new NullPointerException("사다리가 생성되지 않았습니다.");
        }
        System.out.println("실행결과");
        System.out.println(ladder.getSimpleOutput(WIDTH));
    }
}
