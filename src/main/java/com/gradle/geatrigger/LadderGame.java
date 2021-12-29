package com.gradle.geatrigger;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        int peopleCount, height;
        String namesString;
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분하세요)");
        namesString = sc.next();
        System.out.println("참여할 사람은 몇 명인가요?");
        peopleCount = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();

        Ladder ladder = new Ladder(peopleCount, height, namesString);

        ladder.makeLadder();
        System.out.println(ladder.toString());
    }

}

