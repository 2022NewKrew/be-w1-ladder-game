package com.kakao.ui;

import com.kakao.domain.Ladder;

import java.util.*;

public class RunGame {

    private static final GameInput gameInput = new GameInput();
    private static GameOutput gameOutput;

    public static void checkGameResult() {
        String participant = gameInput.inputCheckParticipant();
        if (gameOutput.checkParticipant(participant)) {
            checkGameResult();
        }
    }

    public static void main(String[] args) {
        List<String> participants = gameInput.inputParticipants();
        List<String> results = gameInput.inputResults();
        int height = gameInput.inputHeight();

        Ladder ladder = new Ladder(participants, height, results);
        gameOutput = new GameOutput(ladder);

        gameOutput.printLadder();
        checkGameResult();
        System.out.println("\n게임을 종료합니다.");
    }
}
