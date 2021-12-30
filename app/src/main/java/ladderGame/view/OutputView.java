package ladderGame.view;

import java.util.List;

/*
*   출력을 담당하는 class 입니다.
*   사다리와 유저 이름들을 출력해주는 메소드가 모여있습니다.
* */
public class OutputView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BAR = "-".repeat(MAX_NAME_LENGTH);
    private static final String EMPTY = " ".repeat(MAX_NAME_LENGTH);

    // 인스턴스 생성 막기
    private OutputView() {
    }

    public static final void printLadder(LadderGame ladderGame) {
        printPlayers(ladderGame.getPlayers());
        printAllLine(ladderGame.getLadder());
    }

    private static final void printPlayers(List<String> players) {
        for(String player : players) {
            System.out.printf("%6s", player);
        }
        System.out.println();
    }

    private static final void printAllLine(List<Line> ladder) {
        for(Line currentLine : ladder) {
            printLine(currentLine.getPoints());
            System.out.println("|");
        }
    }

    public static final void printLine(List<Boolean> points) {
        System.out.print("   ");
        for(Boolean exist : points) {
            System.out.print("|");
            printBar(exist);
        }
    }

    private static final void printBar(Boolean exist) {
        if(exist) {
            System.out.print(BAR);
            return;
        }
        System.out.print(EMPTY);
    }
}
