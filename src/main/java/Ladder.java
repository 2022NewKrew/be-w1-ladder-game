import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<String> playerList;
    private final List<Line> lineList;

    public Ladder(ArrayList<String> playerNames, int ladderHeight) {
        playerList = List.copyOf(playerNames);
        ArrayList<Line> temp = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            temp.add(new Line(playerNames.size()));
        }
        lineList = List.copyOf(temp);
    }

    public List<String> getPlayerList() {
        return playerList;
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
