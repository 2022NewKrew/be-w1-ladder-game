package ladder.domain.bridge;

import ladder.domain.ladder.LadderInfo;

import java.util.ArrayList;
import java.util.List;

public class BridgeBuilder {

    private final List<Bridge> bridges;
    private final int numOfParticipants;
    private final int height;
    private final RandomBridgeProvider randomBridgeProvider;

    public BridgeBuilder(LadderInfo ladderInfo, RandomBridgeProvider randomBridgeProvider) {
        this.numOfParticipants = ladderInfo.getParticipants().size();
        this.bridges = new ArrayList<>();
        this.height = ladderInfo.getHeight();
        this.randomBridgeProvider = randomBridgeProvider;
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
            return randomBridgeProvider.isConnectableBridgeByRandom();
        }
        return !bridge.isConnected(currentPoint - 1) && randomBridgeProvider.isConnectableBridgeByRandom();
    }

}
