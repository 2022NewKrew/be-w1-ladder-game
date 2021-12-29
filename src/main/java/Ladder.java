import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final LadderInfo info;
    private final ArrayList<ArrayList<Boolean>> connections;
    private final Random random = new Random();

    public Ladder(LadderInfo info) {
        this.info = info;
        connections = makeConnections();
    }

    public ArrayList<ArrayList<Boolean>> makeConnections() {
        ArrayList<ArrayList<Boolean>> connections = new ArrayList<>();
        int heightOfLadder = info.getHeightOfLadder();
        for(int layer = 0; layer < heightOfLadder; layer++) {
            connections.add(makeConnectionsOneLine());
        }
        return connections;
    }

    public ArrayList<Boolean> makeConnectionsOneLine() {
        ArrayList<Boolean> connectionsOneLine = new ArrayList<>();
        int numOfPeople = info.getNumOfPeople();
        for(int person = 0; person < numOfPeople-1; person++) {
            connectionsOneLine.add(random.nextBoolean());
        }
        return connectionsOneLine;
    }


    public LadderInfo getInfo() {
        return info;
    }
    public ArrayList<ArrayList<Boolean>> getConnections() {
        return connections;
    }
}