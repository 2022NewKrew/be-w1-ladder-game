package be.w1.ladder_game.view;

import java.util.List;

import be.w1.ladder_game.model.Bridge;
import be.w1.ladder_game.model.Ladder;
import be.w1.ladder_game.model.Player;

public class OutputView {
    private static final String LADDER_SEPARATOR = "|";
    private static final String FULL_LADDER = "-----";
    private static final String EMPTY_LADDER = "     ";
    private static final String NEW_LINE = "\n";
    private static final String MARGIN = "  ";

    public OutputView() {}

    public void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.printf("%-6s", player.getName());
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        List<Bridge> ladderArray = ladder.getLadderArray();
        StringBuilder result = new StringBuilder();

        for (int row = 0; row < ladderArray.size(); ++row) {
            result.append(MARGIN)
                  .append(getLadderByBridge(ladderArray, row))
                  .append(LADDER_SEPARATOR)
                  .append(NEW_LINE);
        }

        System.out.println(result);
    }

    private String getLadderByBridge(List<Bridge> ladderArray, int row) {
        StringBuilder result = new StringBuilder();

        for (Boolean edges : ladderArray.get(row).getEdges()) {
            String bridge = edges ? FULL_LADDER : EMPTY_LADDER;

            result.append(LADDER_SEPARATOR)
                  .append(bridge);
        }

        return result.toString();
    }
}

