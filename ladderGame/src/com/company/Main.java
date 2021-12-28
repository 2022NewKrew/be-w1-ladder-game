package com.company;

import com.company.ladder.Ladder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇명인가요?");
        int attendant_num = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladder_num = scanner.nextInt();

        Ladder ladder = new Ladder(attendant_num,ladder_num);
        ladder.makeRandomLadder();
        ladder.print();
    }
}
