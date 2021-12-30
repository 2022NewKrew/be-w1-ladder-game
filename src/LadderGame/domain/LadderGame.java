package LadderGame.domain;

import LadderGame.view.LadderView;

import java.util.Scanner;

public class LadderGame {
    // 클래스 변수
    private static final Scanner scanner = new Scanner(System.in);

    public LadderGame() throws Exception {
        String names = getConsoleNameList();
        int ladderHeight = getConsoleLadderHeight();
        scanner.close();

        LadderView ladderView = new LadderView(new Ladder(names, ladderHeight));
        ladderView.showLadder();
    }

    private static String getConsoleNameList() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private static int getConsoleLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        return scanner.nextInt();
    }
}
