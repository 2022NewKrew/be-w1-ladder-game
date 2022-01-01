package com.yapark97.laddergame.ladder.view;

import com.yapark97.laddergame.ladder.domain.Ladder;

import java.util.List;

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
        System.out.println("\n사다리 결과");
        System.out.println(ladder.getSimpleOutput(WIDTH));
    }

    @Override
    public boolean showResult(Ladder ladder, String selection) {
        switch (selection) {
            case Selection.END_OF_GAME:
                System.out.println("\n게임을 종료합니다.");
                return true;
            case Selection.ALL:
                System.out.println("\n실행 결과");
                showAllResult(ladder);
                break;
            default:
                System.out.println("\n실행 결과");
                showOneResult(ladder, selection);
        }
        return false;
    }

    private void showAllResult(Ladder ladder) {
        List<String> participants = ladder.getParticipants();

        for (String participant: participants) {
            System.out.print(participant + " : ");
            showOneResult(ladder, participant);
        }
    }

    private void showOneResult(Ladder ladder, String selection) {
        System.out.println(ladder.getResult(selection));
    }
}
