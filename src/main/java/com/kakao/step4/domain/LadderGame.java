package com.kakao.step4.domain;

import com.kakao.step4.view.LadderView;

import java.util.Scanner;

public class LadderGame {
    private static final Scanner SCAN = new Scanner(System.in);

    private Names names;
    private int countOfLines;

    public LadderGame() {
        try {
            askPeopleNames();
            askCountOfLines();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new LadderView(new Ladder(names, countOfLines));
    }

    private void askPeopleNames() throws Exception {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요. 각 이름은 다섯 글자까지만 사용됩니다.)");
        this.names = new Names(SCAN.nextLine());
    }

    private void askCountOfLines() throws Exception {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        countOfLines = SCAN.nextInt();

        if (countOfLines <= 0) {
            throw new Exception("올바르지 않은 사다리 높이가 입력되었습니다.");
        }
    }
}
