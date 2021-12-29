package step_3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderConnection {
    private final List<Boolean> connection = new ArrayList<>();

    public LadderConnection() {}

    public static LadderConnection initBySize(int width) {
        LadderConnection ladderConnection = new LadderConnection();
        IntStream.range(0, width)
                .forEach(col -> ladderConnection.connection.add(false));
        return ladderConnection;
    }

    public List<Boolean> getConnect() {
        return connection;
    }

    public void setConnect(int index, Boolean value) {
        connection.set(index, value);
    }

    public Boolean isLeftConnected(int index) {
        return index >= 1 && connection.get(index - 1);
    }
}
