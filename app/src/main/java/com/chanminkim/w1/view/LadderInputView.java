package com.chanminkim.w1.view;

import com.chanminkim.w1.controller.LadderGameDTO;

import java.security.SecureRandom;
import java.util.Scanner;

public class LadderInputView {
    private final Scanner scanner = new Scanner(System.in);

    public LadderGameDTO getUserInput() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = scanner.nextInt();
        System.out.println();

        return new LadderGameDTO(numberOfPlayers, heightOfLadder, new SecureRandom());
    }

}
