package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> connectionList;

    public Line(List<Boolean> connectionList) {
        this.connectionList = new ArrayList<>(connectionList);
    }

    public static Line from(int numberOfPlayer) {
        List<Boolean> connectionList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer - 1; i++) {
            connectionList.add(random.nextBoolean());
            removeDuplicatedConnection(connectionList);
        }
        return new Line(connectionList);
    }

    private static void removeDuplicatedConnection(List<Boolean> connectionList) {
        if (connectionList.size() < 2) {
            return;
        }
        boolean previousConnection = connectionList.get(connectionList.size() - 2);
        if (previousConnection) {
            connectionList.set(connectionList.size() - 1, false);
        }
    }

    public List<Boolean> getConnectionList() {
        return Collections.unmodifiableList(connectionList);
    }
}
