package be.w1.ladder_game.view;

import java.util.List;

import be.w1.ladder_game.model.Ladder;

public class OutputView {
    private static final String LADDER_SEPARATOR = "|";
    private static final String FULL_LADDER = "-----";
    private static final String EMPTY_LADDER = "     ";
    private static final String NEW_LINE = "\n";
    private static final String MARGIN = "  ";

    public OutputView() {}

    public void printPlayers(List<String> players) {
        for (String player : players) {
            System.out.printf("%-6s", player);
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        List<List<Boolean>> ladderArray = ladder.getLadderArray();
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < ladderArray.size(); ++row) {
            result.append(MARGIN)
                  .append(getLadderByBridge(ladderArray, row))
                  .append(LADDER_SEPARATOR)
                  .append(NEW_LINE);
        }

        System.out.println(result);
    }

    private String getLadderByBridge(List<List<Boolean>> ladderArray, int row) {
        StringBuilder result = new StringBuilder();

        for (Boolean bridgeState : ladderArray.get(row)) {
            String bridge = bridgeState ? FULL_LADDER : EMPTY_LADDER;

            result.append(LADDER_SEPARATOR)
                  .append(bridge);
        }

        return result.toString();
    }
}
