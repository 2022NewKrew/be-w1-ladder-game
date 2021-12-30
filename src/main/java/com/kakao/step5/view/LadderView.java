package com.kakao.step5.view;

import com.kakao.step5.domain.model.Ladder;
import com.kakao.step5.domain.model.Names;

import java.util.Scanner;

public class LadderView {
    private static final Scanner SCAN = new Scanner(System.in);

    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    public static Names askPeopleNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요. 각 이름은 다섯 글자까지만 사용됩니다.)");
        return new Names(SCAN.nextLine());
    }

    public static int askCountOfLines() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int countOfLines = SCAN.nextInt();

        if (countOfLines <= 0) {
            throw new NumberFormatException("올바르지 않은 사다리 높이가 입력되었습니다.");
        }

        return countOfLines;
    }

    public void printLadder() {
        System.out.println("사다리 결과");
        System.out.print(ladder);
    }
}

