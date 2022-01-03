package ladderGame.view;

import java.util.List;

/*
*   출력을 담당하는 class 입니다.
*   사다리와 유저 이름들을 출력해주는 메소드가 모여있습니다.
* */
public final class OutputView {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String BAR = "-".repeat(MAX_NAME_LENGTH);
    private static final String EMPTY = " ".repeat(MAX_NAME_LENGTH);

    // 인스턴스 생성 막기
    private OutputView() {
    }

    public static final void printLadder(List<String> players, List<Line> ladder, List<String> results) {
        printPlayers(players);
        printAllLine(ladder);
        printResults(results);
    }

    private static void printPlayers(List<String> players) {
        for(String player : players) {
            System.out.printf("%6s", player);
        }
        System.out.println();
    }

    private static void printAllLine(List<Line> ladder) {
        for(Line currentLine : ladder) {
            printLine(currentLine.getPoints());
            System.out.println("|");
        }
    }

    private static void printLine(List<Boolean> points) {
        System.out.print("   ");
        for(Boolean exist : points) {
            System.out.print("|");
            printBar(exist);
        }
    }

    public static final void printResults(List<String> results) {
        for(String result : results) {
            System.out.printf("%6s", result);
        }
        System.out.println();
    }

    private static void printBar(Boolean exist) {
        if(exist) {
            System.out.print(BAR);
            return;
        }
        System.out.print(EMPTY);
    }

    public static final void printAllResult(List<String> players, List<String> results) {
        for(int i = 0; i < players.size(); i++)
            System.out.println(players.get(i) + " : " + results.get(i));
    }

    public static final void printOneResult(String result) {
        System.out.println("\n실행결과");
        System.out.println(result);
    }
}
