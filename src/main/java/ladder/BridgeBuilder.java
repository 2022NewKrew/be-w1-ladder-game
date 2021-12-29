package ladder;

public class BridgeBuilder {

    private final boolean[][] bridges;
    private final int numOfParticipants;
    private final int height;
    private final RandomBridgeManger randomBridgeManger;

    public BridgeBuilder(String[] participants, int height, RandomBridgeManger randomBridgeManger) {
        this.numOfParticipants = participants.length;
        this.bridges = new boolean[height][numOfParticipants - 1];
        this.height = height;
        this.randomBridgeManger = randomBridgeManger;
    }

    public boolean[][] build() {
        connectBridges();
        return bridges;
    }

    private void connectBridges() {
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            connectRowBridges(currentHeight);
        }
    }

    private void connectRowBridges(int currentHeight) {
        for (int currentWidth = 0; currentWidth < numOfParticipants - 1; currentWidth++) {
            connectBridge(currentWidth, currentHeight);
        }
    }

    private void connectBridge(int bridgeWidth, int bridgeHeight) {
        bridges[bridgeHeight][bridgeWidth] = isConnectableBridge(bridgeWidth, bridgeHeight);
    }

    private boolean isConnectableBridge(int bridgeWidth, int bridgeHeight) {
        if (bridgeWidth == 0) {
            return randomBridgeManger.isConnectableBridgeByRandom();
        }
        return !isAlreadyConnected(bridgeWidth, bridgeHeight) && randomBridgeManger.isConnectableBridgeByRandom();
    }

    private boolean isAlreadyConnected(int bridgeWidth, int bridgeHeight) {
        return bridges[bridgeHeight][bridgeWidth - 1];
    }


}
