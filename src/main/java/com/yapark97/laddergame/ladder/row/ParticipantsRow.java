package com.yapark97.laddergame.ladder.row;

import com.yapark97.laddergame.ladder.LadderConst;

import java.util.List;

public class ParticipantsRow implements Row {
    private final List<String> participants;

    public ParticipantsRow(List<String> participants) {
        this.participants = participants;
    }

    @Override
    public void print() {
        for (String participant : participants) {
            printColumn(participant);
        }
        System.out.print("\n");
    }

    private void printColumn(String participant) {
        int leftPadding = Math.max(0, (LadderConst.WIDTH - participant.length())/2);
        int rightPadding = Math.max(0, (LadderConst.WIDTH - participant.length() - 1)/2 + 1);

        for (int i=0; i<leftPadding; i++) {
            System.out.print(LadderConst.BLANK);
        }
        String format = "%." + LadderConst.WIDTH + "s";
        System.out.printf(format, participant);
        for (int i=0; i<rightPadding; i++) {
            System.out.print(LadderConst.BLANK);
        }
    }
}
