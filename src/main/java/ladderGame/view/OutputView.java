package ladderGame.view;

import ladderGame.domain.*;

import java.util.List;

public final class OutputView {
    private static final char PILLAR = '|';
    private static final String CONNECT_BRANCH = "-----";
    private static final String DISCONNECT_BRANCH = "     ";

    private OutputView() { }

    public static void drawLadderGame(Players players, Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        sb.append(drawPlayerName(players)).append("\n");

        final List<LadderLine> ladderLines = ladder.getLadderLines();
        for (LadderLine ladderLine : ladderLines) {
            sb.append(drawLadderLine(ladderLine)).append("\n");
        }

        System.out.println(sb);
    }

    private static String drawLadderLine(LadderLine ladderLine) {
        StringBuilder sb = new StringBuilder();
        final List<LadderLineBranch> ladderLineBranches = ladderLine.getladderLineBranches();

        sb.append("   ").append(PILLAR);
        for (LadderLineBranch ladderLineBranch : ladderLineBranches) {
            sb.append(getBranch(ladderLineBranch)).append(PILLAR);
        }

        return sb.toString();
    }

    private static String getBranch(LadderLineBranch ladderLineBranch) {
        if (ladderLineBranch.isConnect()) {
            return CONNECT_BRANCH;
        }

        return DISCONNECT_BRANCH;
    }

    private static String drawPlayerName(Players players) {
        StringBuilder sb = new StringBuilder();

        final List<PlayerInfo> playerInfos = players.getPlayerInfos();
        for (PlayerInfo playerInfo : playerInfos) {
            sb.append(String.format("%5s", playerInfo.getName())).append(" ");
        }

        return sb.toString();
    }
}
