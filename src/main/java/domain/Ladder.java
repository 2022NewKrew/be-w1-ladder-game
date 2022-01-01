package domain;

import java.util.ArrayList;

public class Ladder {
    private final String[] people;
    private final int heightOfLadder;
    private final ArrayList<Line> connections;

    public Ladder(String[] people, int heightOfLadder) {
        this.people = people;
        this.heightOfLadder = heightOfLadder;
        connections = makeConnections();
    }

    public ArrayList<Line> makeConnections() {
        ArrayList<Line> connections = new ArrayList<>();
        for(int line = 0; line < heightOfLadder; line++) {
            connections.add(new Line(people.length));
        }
        return connections;
    }

    public String[] getPeople() {
        return people;
    }

    public ArrayList<ArrayList<Boolean>> getConnections() {
        ArrayList<ArrayList<Boolean>> connections = new ArrayList<>();
        for(Line line : this.connections){
            connections.add(line.getConnections());
        }
        return connections;
    }
}