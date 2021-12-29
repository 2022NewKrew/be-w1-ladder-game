package com.laddergame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        int peopleNum = in.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderNum = in.nextInt();

        Ladder ladder = new Ladder(peopleNum, ladderNum);
        System.out.println(ladder);
    }
}
