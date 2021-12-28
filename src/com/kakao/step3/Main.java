package com.kakao.step3;

import com.kakao.step3.view.LadderView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int countOfPeople = scan.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int countOfLines  = scan.nextInt();

        LadderView ladderView = new LadderView(countOfPeople, countOfLines);

        ladderView.printLadder();
    }
}

