package connector;

import line.Line;

import java.util.Random;

public class RandomConnector implements Connector {

    private static final Random random = new Random();

    @Override
    public boolean isConnected(Line prevLine, Line nextLine, int position) {
        Line connectedPrevLine = prevLine.getConnectedLine(position);
        Line connectedNextLine = nextLine.getConnectedLine(position);
        return isNotNull(connectedPrevLine, connectedNextLine) && connectedPrevLine.equals(nextLine) && connectedNextLine.equals(prevLine);
    }

    @Override
    public void connectLine(Line prevLine, Line nextLine) {
        for (int i = 0; i < prevLine.getHeight(); i++) {
            connect(prevLine, nextLine, i);
        }
    }

    private boolean isNotNull(Line prevLine, Line nextLine) {
        return prevLine != null && nextLine != null;
    }

    private void connect(Line prevLine, Line nextLine, int position) {
        if (isConnectable(prevLine, nextLine, position) && random.nextBoolean()) {
            prevLine.connect(nextLine, position);
            nextLine.connect(prevLine, position);
        }
    }

    private boolean isConnectable(Line prevLine, Line nextLine, int position) {
        return prevLine.isConnectable(position) && nextLine.isConnectable(position);
    }
}
