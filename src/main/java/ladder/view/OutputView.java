package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PADDING = "  ";
    private final int maxUserNameLength;

    public OutputView(int maxUserNameLength) {
        this.maxUserNameLength = maxUserNameLength;
    }

    public void printLadder(List<Player> players, List<Result> results, Ladder ladder) {
        int ladderHeight = ladder.getMaxLadderHeight();

        System.out.println("\n사다리 결과\n");
        printPlayers(players);

        for (int i = 0; i < ladderHeight; i++) {
            LadderRow ladderRow = ladder.getLadderRow(i);
            printLadderRow(ladderRow);
        }
        printResults(results);
    }

    private void printPlayers(List<Player> players) {
        players.forEach(player -> System.out.printf("%5s ", player + getNamePadding(player.getNameLength())));
        System.out.println();
    }

    private void printResults(List<Result> results) {
        results.forEach(result -> System.out.printf("%5s ", result + getNamePadding(result.getResultLength())));
        System.out.println("\n");
    }

    private String getNamePadding(int nameLength) {
        return " ".repeat((maxUserNameLength - nameLength) / 2);
    }

    private void printLadderRow(LadderRow ladderRow) {
        List<LadderCell> row = ladderRow.getRow();
        System.out.print(PADDING);

        for (LadderCell ladderCell : row) {
            System.out.print(LineType.VERTICAL_LINE);
            System.out.print(ladderCell.getLine());
        }
        System.out.println(LineType.VERTICAL_LINE);
    }

    public void printResult(String playerName, Map<String, String> resultMap) {
        if (playerName.equals("all")) {
            printGameResultAll(resultMap);
            return;
        }
        if (!resultMap.containsKey(playerName)) {
            return;
        }
        printGameResult(playerName, resultMap);
    }

    private void printGameResult(String playerName, Map<String, String> resultMap) {
        System.out.println("\n실행결과");
        System.out.println(resultMap.get(playerName) + "\n");
    }

    private void printGameResultAll(Map<String, String> resultMap) {
        System.out.println("\n실행결과");
        resultMap.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();
    }

    public void printGameEnd() {
        System.out.println("\n게임을 종료합니다.");
    }
}
