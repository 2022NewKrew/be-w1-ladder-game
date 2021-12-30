package domain;

import java.util.ArrayList;

public class LadderPlayers {
    private final ArrayList<String> players;

    public LadderPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public int length() {
        return players.size();
    }

    public StringBuilder toStringBuilder(int maxPlayerNameLength) {
        StringBuilder ladderPlayerStringBuilder = new StringBuilder();
        for (String player : players) {
            ladderPlayerStringBuilder.append(alignCenter(player, maxPlayerNameLength));
            ladderPlayerStringBuilder.append(" ");
        }
        ladderPlayerStringBuilder.append("\n");
        return ladderPlayerStringBuilder;
    }

    private StringBuilder alignCenter(String s, int maxLength) {
        StringBuilder centeredStringBuilder = new StringBuilder();
        int leftPadding = (maxLength - s.length()) / 2;
        int rightPadding = maxLength - s.length() - leftPadding;
        centeredStringBuilder.append(" ".repeat(leftPadding));
        centeredStringBuilder.append(s);
        centeredStringBuilder.append(" ".repeat(rightPadding));
        return centeredStringBuilder;
    }
}
