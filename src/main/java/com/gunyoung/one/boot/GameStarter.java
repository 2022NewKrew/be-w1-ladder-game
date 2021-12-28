package com.gunyoung.one.boot;

import java.util.Scanner;

public class GameStarter {

    /**
     * for Singleton
     */
    private static GameStarter INSTANCE;

    private GameStarter() {}

    public static GameStarter getInstance() {
        if(INSTANCE == null)
            INSTANCE = new GameStarter();
        return INSTANCE;
    }

    private final Scanner scanner = new Scanner(System.in);

    /**
     * 게임을 시작한다
     */
    public void start() {
        inputDataForLadder();
        drawLadder();
    }

    private void inputDataForLadder() {
        int numOfUser = inputNumberOfUser();
        int ladderHeight = inputLadderHeight();
        Ladder.init(numOfUser, ladderHeight);
    }

    private int inputNumberOfUser() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    private int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private void drawLadder() {
        Ladder.getInstance().drawLadder();
    }
}
