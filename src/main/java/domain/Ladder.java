package domain;

import java.util.ArrayList;

public class Ladder {
    private final LadderPlayers ladderPlayers;
    private final LadderData ladderData;

    public Ladder(ArrayList<String> players, int maxHeight) {
        ladderPlayers = new LadderPlayers(players);
        ladderData = new LadderData(maxHeight, ladderPlayers.length() - 1);
    }

    public StringBuilder toStringBuilder(int maxPlayerNameLength) {
        StringBuilder ladderStringBuilder = new StringBuilder();
        ladderStringBuilder.append(ladderPlayers.toStringBuilder(maxPlayerNameLength));
        ladderStringBuilder.append(ladderData.toStringBuilder(maxPlayerNameLength));
        return ladderStringBuilder;
    }
}
