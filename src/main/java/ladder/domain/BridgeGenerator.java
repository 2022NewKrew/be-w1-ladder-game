package main.java.ladder.domain;

import java.util.Random;

public class BridgeGenerator {
    private static final Random random = new Random();
    private boolean isLastConnected = false;

    public LadderBridge generateBridge() {
        if (isLastConnected || !random.nextBoolean()) {
            isLastConnected = false;
            return LadderBridge.BRIDGE_DISCONNECTED;
        }
        isLastConnected = true;
        return LadderBridge.BRIDGE_CONNECTED;
    }
}
