import java.util.ArrayList;
import java.util.Random;

public class LadderMaker {
    private final LadderInfo info;
    private final Random random = new Random();

    public LadderMaker(LadderInfo info) {
        this.info = info;
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
}
