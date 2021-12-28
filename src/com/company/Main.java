package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("인원 수를 입력해주세요.");
        int numOfPeople = sc.nextInt();
        System.out.println("사다리 높이를 입력해주세요.");
        int height = sc.nextInt();

        Ladder ladder = new Ladder(numOfPeople, height);
        ladder.printLadder();
    }
}
