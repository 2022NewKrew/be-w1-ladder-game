package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final String NEWLINE = "\n";
    private static final int LADDER_WIDTH = 5;
    private static final int NAME_GAP = 1;

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

    public StringBuilder lineListToString() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lineList) {
            sb.append(line.pointListToString());
            sb.append(NEWLINE);
        }
        return sb;
    }

    public StringBuilder playerListToString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : playerList) {
            sb.append(player.getNameWithGap(LADDER_WIDTH, NAME_GAP));
        }
        return sb;
    }
}
