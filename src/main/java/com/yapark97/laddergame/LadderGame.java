package com.yapark97.laddergame;

import com.yapark97.laddergame.ladder.Ladder;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderGame {
    private final Scanner sc = new Scanner(System.in);
    private Ladder ladder = null;

    public void initGame() {
        ladder = createLadder();
    }

    public void showStatus() {
        if (ladder == null) {
            throw new NullPointerException("사다리가 생성되지 않았습니다.");
        }
        ladder.printLadder();
    }

    private Ladder createLadder() {
        int participantsNum = takeParticipantsNumInput();
        int maxHeight = takeMaxHeightInput();

        return new Ladder(participantsNum, maxHeight);
    }

    private int takeParticipantsNumInput() {
        int participantsNum;

        System.out.println("참여할 사람은 몇 명인가요?");
        try {
            participantsNum = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("참여자 수는 정수여야 합니다.");
        }
        if (participantsNum <= 1) {
            throw new InputMismatchException("참여자 수는 2명 이상이어야 합니다.");
        }
        return participantsNum;
    }

    private int takeMaxHeightInput() {
        int maxHeight;

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            maxHeight = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("최대 사다리 높이는 정수여야 합니다.");
        }
        if (maxHeight <= 0) {
            throw new InputMismatchException("최대 사다리 높이는 1 이상이어야 합니다.");
        }
        return maxHeight;
    }
}
