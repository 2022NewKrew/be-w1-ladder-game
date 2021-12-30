package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Player> playerList;
    private final List<Line> lineList;

    public Ladder(ArrayList<String> playerNames, int ladderHeight) {
        ArrayList<Player> temp1 = new ArrayList<>();
        for (String playerName : playerNames) {
            temp1.add(new Player(playerName));
        }
        playerList = List.copyOf(temp1);
        ArrayList<Line> temp2 = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            temp2.add(new Line(playerNames.size()));
        }
        lineList = List.copyOf(temp2);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
