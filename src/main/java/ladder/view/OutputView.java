package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {

    public static class LazyHolder {
        public static final OutputView INSTANCE = new OutputView();
    }

    private OutputView() {
    }

    public static OutputView getInstance() {
        return OutputView.LazyHolder.INSTANCE;
    }

    public void printLadderGameResults(Players players, Ladder ladder, Results results) {
        System.out.println("사다리 결과");
        printPlayersName(players);
        printLadder(ladder, players.getPlayersCnt());
        printResults(results);
    }

    private void printPlayersName(Players players) {
        players.getPlayersName()
                .forEach(n -> System.out.printf("%5s ", n));
        System.out.println();
    }

    private void printLadder(Ladder ladder, int playersCnt) {
        List<Line> curLadder = ladder.getLadder();

        for (int i = 0; i < ladder.getHeight(); i++) {
            printLadderRow(curLadder, i, playersCnt);
        }
    }

    private void printResults(Results results) {
        results.getResults()
                .forEach(r -> System.out.printf("%5s ", r));
        System.out.println();
    }

    private void printLadderRow(List<Line> ladder, int curHeight, int playersCnt) {
        System.out.print("   ");
        for (int i = 0; i < playersCnt - 1; i++) {
            Line curLine = ladder.get(i);
            Bridge bridge = curLine.getLine().get(curHeight);

            System.out.print("|");
            if (bridge.isExist()) {
                System.out.print("-----");
                continue;
            }
            System.out.print("     ");
        }
        System.out.println("|");
    }

}
