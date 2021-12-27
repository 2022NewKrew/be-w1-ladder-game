package com.kakao.newcrew;

import java.util.Scanner;

public class Runner {
    private static final String PEOPLE_COUNT_INPUT_MESSAGE  = "참여할 사람은 몇 명인가요?";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(PEOPLE_COUNT_INPUT_MESSAGE);
        int peopleCount = scanner.nextInt();

        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        int ladderHeight = scanner.nextInt();

        LadderGame ladderGame = new LadderGame(peopleCount, ladderHeight);
        ladderGame.startGame();
    }
}
