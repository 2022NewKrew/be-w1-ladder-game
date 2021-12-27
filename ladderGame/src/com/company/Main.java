package com.company;

import com.company.ladder.ladder;

import java.util.Scanner;

public class Main {
    static int attendant_num = 3;
    static int ladder_num = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇명인가요?");
        attendant_num = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladder_num = scanner.nextInt();

        ladder ladder = new ladder(attendant_num,ladder_num);
        ladder.makeRandomLadder();
        ladder.print();
    }
}
