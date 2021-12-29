package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height;
        String names;
        String[] namesArr;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 ,(쉼표)로 구분");
        names = sc.nextLine();
        namesArr = names.split(",");

        System.out.println("사다리 높이를 입력해주세요.");
        height = sc.nextInt();

        Ladder ladder = new Ladder(namesArr, height);
        ladder.printLadder();
    }
}

