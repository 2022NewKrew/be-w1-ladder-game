package com.kakao.view;

import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {}

    public String[] inputNameOfPlayers() {
        System.out.println("참여할 플레이어 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        System.out.println();
        return line.split(DELIMITER);
    }

    public int inputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        System.out.println();
        return height;
    }
}
