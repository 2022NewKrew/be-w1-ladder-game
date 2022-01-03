package com.company;

import com.company.domain.Ladder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height;
        String[] namesArr, resultsArr;


        namesArr = inputName(sc).split(",");
        resultsArr = inputResult(sc).split(",");
        if (namesArr.length != resultsArr.length) {
            System.out.println("이름과 결과의 수가 일치하지 않습니다.");
            return;
        }
        height = inputHeight(sc);

        sc.nextLine();

        Ladder ladder = new Ladder(namesArr, resultsArr, height);
        ladder.printLadder();

        boolean escape = false;
        while (!escape) {
            escape = inputNameForResult(sc, ladder);
        }
    }

    public static String inputName(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 ,(쉼표)로 구분 / 최대 5글자)");
        return sc.nextLine();
    }

    public static String inputResult(Scanner sc) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static int inputHeight(Scanner sc) {
        System.out.println("사다리 높이를 입력해주세요.");
        return sc.nextInt();
    }

    public static boolean inputNameForResult(Scanner sc, Ladder ladder) {
        System.out.println("결과를 보고 싶은 사람은?");
        String input = sc.nextLine();

        if (input.equals("춘식이")) return true;

        System.out.println("실행 결과");
        if (input.equals("all")) {
            ladder.printResultList();
            return false;
        }
        ladder.printResultOfName(input);
        return false;
    }
}

