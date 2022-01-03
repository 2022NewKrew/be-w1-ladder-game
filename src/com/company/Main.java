package com.company;

import com.company.domain.Ladder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height;
        String names, results, input = "";
        String[] namesArr, resultsArr;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 ,(쉼표)로 구분 / 최대 5글자)");
        names = sc.nextLine();
        namesArr = names.split(",");

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        results = sc.nextLine();
        resultsArr = results.split(",");

        System.out.println("사다리 높이를 입력해주세요.");
        height = sc.nextInt();
        sc.nextLine();

        Ladder ladder = new Ladder(namesArr, resultsArr, height);
        ladder.printLadder();

        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            input = sc.nextLine();

            if (input.equals("춘식이")) break;

            System.out.println("실행 결과");
            if (input.equals("all")) {
                ladder.printResultList();
                continue;
            }
            ladder.printResultOfName(input);
        }
    }


}

