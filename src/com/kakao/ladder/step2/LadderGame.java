package com.kakao.ladder.step2;

import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people, height;

        System.out.println("참여할 사람은 몇 명인가요?");
        people = s.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = s.nextInt();

        Ladder ladder = new Ladder(people, height);
        ladder.printLadder();
    }
}