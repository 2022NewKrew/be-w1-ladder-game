package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderConnection {
    private final List<Boolean> connection = new ArrayList<>();

    protected LadderConnection() {}

    protected static LadderConnection initBySize(int width) {
        LadderConnection ladderConnection = new LadderConnection();
        IntStream.range(0, width)
                .forEach(col -> ladderConnection.connection.add(false));
        return ladderConnection;
    }

    public void setConnect(int index, Boolean value) {
        connection.set(index, value);
    }

    public List<Boolean> getConnect() {
        return connection;
    }

    public Boolean isLeftConnected(int index) {
        return index > 0 && connection.get(index - 1);
    }

    public Boolean isRightConnected(int width, int index) {
        return index < width - 1 && connection.get(index);
    }
}
