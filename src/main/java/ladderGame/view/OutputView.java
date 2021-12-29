package ladderGame.view;

import ladderGame.model.Ladder;
import ladderGame.model.LadderLine;
import ladderGame.model.Player;

import java.util.List;

public class OutputView {
    private static final char PILLAR = '|';
    private static final String CONNECT_BRANCH = "-----";
    private static final String DISCONNECT_BRANCH = "     ";

    public static void drawLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        final List<LadderLine> ladderLines = ladder.getLadderLines();
        for (LadderLine ladderLine : ladderLines) {
            sb.append(drawLadderLine(ladderLine)).append("\n");
        }

        System.out.println(sb);
    }

    private static String drawLadderLine(LadderLine ladderLine) {
        StringBuilder sb = new StringBuilder();
        final List<Boolean> oneLadderLines = ladderLine.getOneLadderLines();

        sb.append("   ").append(PILLAR);
        for (boolean oneLadderLine : oneLadderLines) {
            sb.append(getBranch(oneLadderLine)).append(PILLAR);
        }

        return sb.toString();
    }

    private static String getBranch(boolean oneLadderLine) {
        if (oneLadderLine) {
            return CONNECT_BRANCH;
        }

        return DISCONNECT_BRANCH;
    }

    public static void drawPlayerName(Player player) {
        StringBuilder sb = new StringBuilder();

        final List<String> playerNameList = player.getPlayerNameList();
        for (String playerName : playerNameList) {
            sb.append(String.format("%5s", playerName)).append(" ");
        }

        System.out.println(sb);
    }
}
