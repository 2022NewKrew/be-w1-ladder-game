package ladder;

public class Ladder {

    private final int participants;
    private final int height;
    private final boolean[][] bridges;

    public Ladder(int participants, int height) {
        this.participants = participants;
        this.height = height;
        this.bridges = new boolean[height][participants - 1];
        connectBridges();
    }

    private void connectBridges() {
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            connectRowBridges(currentHeight);
        }
    }

    private void connectRowBridges(int currentHeight) {
        for (int currentWidth = 0; currentWidth < participants - 1; currentWidth++) {
            connectBridge(currentWidth, currentHeight);
        }
    }

    private void connectBridge(int bridgeWidth, int bridgeHeight) {
        if (isValidConnection(bridgeWidth, bridgeHeight)) {
            bridges[bridgeHeight][bridgeWidth] = true;
        }
    }

    private boolean isValidConnection(int bridgeWidth, int bridgeHeight) {
        if (bridgeWidth == 0) {
            return getRandomBoolean();
        }
        return !isAlreadyConnected(bridgeWidth, bridgeHeight) && getRandomBoolean();
    }

    private boolean isAlreadyConnected(int bridgeWidth, int bridgeHeight) {
        return bridges[bridgeHeight][bridgeWidth - 1];
    }

    private boolean getRandomBoolean() {
        return Math.random() > 0.5;
    }

    public int getParticipants() {
        return participants;
    }

    public int getHeight() {
        return height;
    }

    public boolean isConnected(int bridgeWidth, int bridgeHeight) {
        return bridges[bridgeHeight][bridgeWidth];
    }
}
