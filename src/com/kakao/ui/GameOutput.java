package com.kakao.ui;

import com.kakao.domain.Ladder;
import com.kakao.domain.Line;

import java.util.*;

public class GameOutput {

    private final Ladder ladder;

    public GameOutput(Ladder ladder) { this.ladder = ladder; }

    public void printLadder() {
        List<String> participants = ladder.getParticipants();
        List<String> results = ladder.getResults();

        System.out.println("\n사다리 결과");
        System.out.println("\n" + String.join(" ", participants));
        for (Line line: ladder.getLadder()) {
            System.out.println(line);
        }
        System.out.println(String.join(" ", results));
    }

    public Boolean checkParticipant(String participant) {
        Map<String, String> awards = ladder.getAwards();
        if (participant.equals("춘식이")) { return false; }

        if (participant.equals("all")) { return printGameResult(awards); }

        if (!awards.containsKey(participant)) {
            String participants = String.join(" , ", ladder.getParticipants());
            System.out.println("\n참가자를 다시 확인해 주세요.");
            System.out.printf("참가자 : %s\n", participants);
            return true;
        }

        return printGameResult(participant, awards);
    }

    private Boolean printGameResult(String participant, Map<String, String> awards) {
        System.out.println("\n실행 결과");
        System.out.println(awards.get(participant));
        return true;
    }

    private Boolean printGameResult(Map<String, String> awards) {
        System.out.println("\n실행 결과");
        awards.forEach((participant, award) -> {
            System.out.println(participant + " : " + award);
        });
        return true;
    }
}
