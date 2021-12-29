package com.kakaocorp.ladder;

import com.kakaocorp.ladder.model.Ladder;
import com.kakaocorp.ladder.policy.GamePolicy;
import com.kakaocorp.ladder.service.LadderService;

import java.util.Scanner;

public class Main {

    private static final int MAX_PARTICIPANT = 5;

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] participants = sc.nextLine().split(",");
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        GamePolicy policy = new GamePolicy(MAX_PARTICIPANT);
        LadderService service = new LadderService(policy);
        Ladder ladder = service.initialize(height, participants);
        String s = service.buildString(ladder);

        System.out.println(s);
    }
}
