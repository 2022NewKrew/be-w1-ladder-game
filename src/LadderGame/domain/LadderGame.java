package LadderGame.domain;

import LadderGame.view.LadderView;

import java.util.Scanner;

public class LadderGame {
    // 클래스 변수
    private static final Scanner scanner = new Scanner(System.in);

    private static Ladder ladder;

    public LadderGame() throws Exception {
        ladder = createLadder();
        LadderView ladderView = new LadderView(ladder);

        ladderView.showLadder();

        ladder.createLadderGameResult();
        getConsoleLadderResult();

        scanner.close();
    }

    private void getConsoleLadderResult() {
        String userInput = "";
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            userInput = scanner.nextLine();
            if (userInput.compareTo("춘식이") == 0) {
                System.out.println("게임을 종료합니다.");
                return;
            }
            getRunResult(userInput);
        }
    }

    private void getRunResult(String user){
        System.out.println("실행 결과");
        String userResult = ladder.getResult(user);
        System.out.println(userResult + "\n");
    }

    private Ladder createLadder() throws Exception {
        String names = getConsoleNameList();
        String resultLine = getConsoleResultList();
        int ladderHeight = getConsoleLadderHeight();
        scanner.nextLine();

        return new Ladder(names, resultLine, ladderHeight);
    }

    private String getConsoleResultList() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private String getConsoleNameList() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private int getConsoleLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요 ?");
        return scanner.nextInt();
    }
}
