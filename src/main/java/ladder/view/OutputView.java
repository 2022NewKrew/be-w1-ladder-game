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

    public void printPlayersName(Players players) {
        List<Player> playerList = players.getPlayers();

        for (Player player : playerList) {
            System.out.printf("%5s ", player.getName());
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder, int playersCnt) {
        List<Line> curLadder = ladder.getLadder();

        for (int i = 0; i < ladder.getHeight(); i++) {
            printLadderRow(curLadder, i, playersCnt);
        }
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
