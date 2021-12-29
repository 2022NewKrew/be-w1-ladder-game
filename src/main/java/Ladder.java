import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int numOfPeople;
    private final int heightOfLadder;
    private final ArrayList<ArrayList<Boolean>> connections;
    private final Random random = new Random();

    public Ladder(int numOfPeople, int heightOfLadder) {
        this.numOfPeople = numOfPeople;
        this.heightOfLadder = heightOfLadder;
        connections = makeConnections();
    }

    public ArrayList<ArrayList<Boolean>> makeConnections() {
        ArrayList<ArrayList<Boolean>> connections = new ArrayList<>();
        for(int layer = 0; layer < heightOfLadder; layer++) {
            connections.add(makeConnectionsOneLine());
        }
        return connections;
    }

    public ArrayList<Boolean> makeConnectionsOneLine() {
        ArrayList<Boolean> connectionsOneLine = new ArrayList<>();
        for(int person = 0; person < numOfPeople-1; person++) {
            connectionsOneLine.add(random.nextBoolean());
        }
        return connectionsOneLine;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public ArrayList<ArrayList<Boolean>> getConnections() {
        return connections;
    }
}