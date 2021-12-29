package laddergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> connectionList = new ArrayList<>();

    public Line(int numberOfGamer) {
        for (int i = 0; i < numberOfGamer - 1; i++) {
            connectionList.add(random.nextBoolean());
            removeDuplicatedConnection();
        }
    }

    private void removeDuplicatedConnection() {
        if (connectionList.size() < 2) {
            return;
        }
        boolean previousConnection = connectionList.get(connectionList.size() - 2);
        boolean currentConnection = connectionList.get(connectionList.size() - 1);
        if (previousConnection && currentConnection) {
            connectionList.set(connectionList.size() - 1, false);
        }
    }

    public List<Boolean> getConnectionList() {
        return Collections.unmodifiableList(connectionList);
    }
}
