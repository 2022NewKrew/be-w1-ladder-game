import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final String[] people;
    private final int heightOfLadder;
    private final ArrayList<Line> connections;
    private final Random random = new Random();

    public Ladder(String[] people, int heightOfLadder) {
        this.people = people;
        this.heightOfLadder = heightOfLadder;
        connections = makeConnections();
    }

    public ArrayList<Line> makeConnections() {
        ArrayList<Line> connections = new ArrayList<>();
        for(int line = 0; line < heightOfLadder; line++) {
            connections.add(new Line(people.length, random));
        }
        return connections;
    }

    public String[] getPeople() {
        return people;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public ArrayList<Line> getConnections() {
        return connections;
    }
}