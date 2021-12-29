package ladder;

import java.util.ArrayList;
import java.util.List;

public class BridgeBuilder {

    private final List<Bridge> bridges;
    private final int numOfParticipants;
    private final int height;
    private final RandomBridgeManger randomBridgeManger;

    public BridgeBuilder(String[] participants, int height, RandomBridgeManger randomBridgeManger) {
        this.numOfParticipants = participants.length;
        this.bridges = new ArrayList<>();
        this.height = height;
        this.randomBridgeManger = randomBridgeManger;
    }

    public List<Bridge> build() {
        connectBridges();
        return bridges;
    }

    private void connectBridges() {
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            connectRowBridges();
        }
    }

    private void connectRowBridges() {

        Bridge bridge = new Bridge();

        for (int currentPoint = 0; currentPoint < numOfParticipants - 1; currentPoint++) {
            bridge.addPoint(isConnectableBridge(bridge, currentPoint));
        }

        bridges.add(bridge);
    }

    private boolean isConnectableBridge(Bridge bridge, int currentPoint) {
        if (currentPoint == 0) {
            return randomBridgeManger.isConnectableBridgeByRandom();
        }
        return !bridge.isConnected(currentPoint - 1) && randomBridgeManger.isConnectableBridgeByRandom();
    }

}
