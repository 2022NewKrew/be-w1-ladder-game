package com.kakao.step3.domain;

import java.util.Scanner;

public class GetInfos {
    private static final Scanner SCAN = new Scanner(System.in);

    public static String[] getPeopleNames() {
        String[] names = null;

        while(names == null) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            names = ManipulateInfos.splitToNames(SCAN.nextLine());
        }

        return names;
    }

    public static int getCountOfLines() {
        int countOfLines = 0;

        while(countOfLines <= 0) {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            countOfLines = SCAN.nextInt();
        }

        return countOfLines;
    }
}
