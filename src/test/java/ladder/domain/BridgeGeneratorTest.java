package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class BridgeGeneratorTest {
    public BridgeGenerator bridgeGenerator;

    @BeforeEach
    public void initGenerator() {
        bridgeGenerator = new BridgeGenerator();
    }

    @RepeatedTest(10)
    void generateBridgeTest() {
        final int USER_NUM = 100;
        boolean isLastBridgeConnected = false;
        for (int i = 0; i < USER_NUM - 1; i++) {
            LadderBridge bridge = bridgeGenerator.generateBridge();
            Assertions.assertFalse((bridge == LadderBridge.BRIDGE_CONNECTED) && isLastBridgeConnected);
            isLastBridgeConnected = LadderBridge.BRIDGE_CONNECTED == bridge;
        }
    }
}