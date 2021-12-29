package com.kakao.ui;

import com.kakao.domain.Ladder;

public class RunGame {

    public static void main(String[] args) {
        GameInput gameInput = new GameInput();
        System.out.println("참여할 사람은 몇 명인가요?");
        int participants = gameInput.setParticipants();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = gameInput.setHeight();

        Ladder ladder = new Ladder(participants, height);
        ladder.printLadder();
    }
}
