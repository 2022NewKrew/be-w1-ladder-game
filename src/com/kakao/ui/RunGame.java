package com.kakao.ui;

import com.kakao.domain.Ladder;

import java.util.*;

public class RunGame {

    private static final GameInput gameInput = new GameInput();

    public static void main(String[] args) {
        ArrayList<String> participants = gameInput.inputParticipants();
        int height = gameInput.inputHeight();

        Ladder ladder = new Ladder(participants, height);
        ladder.printLadder();
    }
}
