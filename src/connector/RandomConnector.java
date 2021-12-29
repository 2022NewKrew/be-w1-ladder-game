package connector;

import line.Line;

import java.util.Random;

public class RandomConnector implements Connector {

    private static final Random random = new Random();

    @Override
    public boolean isConnected(Line prevLine, Line nextLine, int position) {
        // connect시 양방향 매핑이 수행되므로 한쪽만 확인해도 연결 여부를 알 수 있다.
        return prevLine.isConnectedTo(nextLine, position);
    }

    @Override
    public void connectLine(Line prevLine, Line nextLine) {
        for (int i = 0; i < prevLine.getHeight(); i++) {
            connect(prevLine, nextLine, i);
        }
    }

    private void connect(Line prevLine, Line nextLine, int position) {
        if (random.nextBoolean()) {
            prevLine.connect(nextLine, position);
        }
    }
}
