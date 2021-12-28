package keith;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private static final char column = '|';
    private static final char connected = '-';
    private static final char notConnected = ' ';

    private final List<List<Boolean>> connections;

    Ladder(int width, int height) {
        this.connections = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            this.connections.add(makeRowConnection(width, random));
        }
    }

    private List<Boolean> makeRowConnection(int width, Random random) {
        List<Boolean> result = new ArrayList<>();
        for (int j = 0; j < width - 1; j++) {
            result.add(random.nextBoolean());
        }
        return result;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (List<Boolean> connectionRow : this.connections) {
            addRowString(connectionRow, result);
        }

        return result.toString();
    }

    private void addRowString(List<Boolean> connectionRow, StringBuilder result) {
        for (Boolean isConnected : connectionRow) {
            result.append(column);
            result.append(isConnected ? connected : notConnected);
        }
        result.append(column);
        result.append('\n');
    }
}
