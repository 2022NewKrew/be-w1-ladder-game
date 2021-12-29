package com.chanminkim.w1;

import com.chanminkim.w1.controller.LadderGameController;

import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LadderGameController ladderGameController = initLadderGameByInput();
        System.out.println(ladderGameController.buildLadder());
    }

    private static LadderGameController initLadderGameByInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = scanner.nextInt();
        System.out.println();

        return new LadderGameController(numberOfPlayers, heightOfLadder, new SecureRandom());
    }
}
