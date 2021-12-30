package com.kakao.ladder.step5.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputLadder {

    static private Scanner scanner = new Scanner(System.in);

    private InputLadder() {}

    static public List<String> inputPeoples() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
    }

    static public List<String> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
    }

    static public int inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}
