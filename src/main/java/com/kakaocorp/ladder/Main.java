package com.kakaocorp.ladder;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.service.LadderService;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int participants = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        Ladder ladder = LadderService.initialize(height, participants);
        String s = LadderService.buildString(ladder);

        System.out.println(s);
    }
}
