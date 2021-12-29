package com.kakao;

import com.kakao.ladder.Ladder;
import java.util.Scanner;

public class Application {

    private static final Scanner sc = new Scanner(System.in);
    private static int numberOfKrew;
    private static int heightOfLadder;

    public static void main(String[] args) {
        try {
            input();
            Ladder ladder = Ladder.create(numberOfKrew, heightOfLadder);
            ladder.drawLines();
            System.out.println(ladder);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void input() {
        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfKrew = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = sc.nextInt();

        sc.close();
    }
}
