package com.kakao.ladder.step4;

import com.kakao.ladder.step4.domain.Ladder;
import com.kakao.ladder.step4.view.LadderPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int height;
        List<String> peoples;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        peoples = new ArrayList<>(Arrays.asList(s.nextLine().split(",")));

        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        height = s.nextInt();
        System.out.println();

        Ladder ladder = new Ladder(peoples, height);
        LadderPrinter ladderPrinter = new LadderPrinter(ladder);
        ladderPrinter.printLadder();
    }
}
