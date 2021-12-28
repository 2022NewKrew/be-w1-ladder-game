package ladder;

public class BridgeBuilder {

    private final boolean[][] bridges;
    private final int participants;
    private final int height;
    private final RandomBridgeManger randomBridgeManger;

    public BridgeBuilder(int participants, int height, RandomBridgeManger randomBridgeManger) {
        this.bridges = new boolean[height][participants - 1];
        this.participants = participants;
        this.height = height;
        this.randomBridgeManger = randomBridgeManger;
    }

    public boolean[][] build() {
        connectBridges(participants, height);
        return bridges;
    }

    private void connectBridges(int participants, int height) {
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            connectRowBridges(participants, currentHeight);
        }
    }

    private void connectRowBridges(int participants, int currentHeight) {
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
            return randomBridgeManger.getRandomBoolean();
        }
        return !isAlreadyConnected(bridgeWidth, bridgeHeight) && randomBridgeManger.getRandomBoolean();
    }

    private boolean isAlreadyConnected(int bridgeWidth, int bridgeHeight) {
        return bridges[bridgeHeight][bridgeWidth - 1];
    }


}
