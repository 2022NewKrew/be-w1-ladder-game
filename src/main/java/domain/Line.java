package domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final ArrayList<Boolean> connections = new ArrayList<>();

    public Line (int numOfPeople) {
        connections.add(random.nextBoolean());
        for(int person = 1; person < numOfPeople - 1; person++) {
            connections.add(!connections.get(person-1) && random.nextBoolean());
        }
    }

    public ArrayList<Boolean> getConnections() {
        return connections;
    }
}
