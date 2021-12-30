package ladder.entity;

import java.util.ArrayList;

public class LadderInput {
    private final int maxHeight;
    private final ArrayList<String> playerList;

    public LadderInput(int maxHeight, ArrayList<String> playerList) {
        this.maxHeight = maxHeight;
        this.playerList = playerList;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public ArrayList<String> getPlayerList() {
        return playerList;
    }
}
