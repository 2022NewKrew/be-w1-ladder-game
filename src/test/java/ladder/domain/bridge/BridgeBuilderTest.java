package ladder.domain.bridge;

import ladder.domain.ladder.LadderInfo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class BridgeBuilderTest {

    private static final String[] PARTICIPANTS = new String[]{"a", "bb", "ccc", "dddd", "eeeee"};
    private static final int HEIGHT = 5;

    @Test
    void 이전_다리에서_연결이_없는경우_연결한다() throws Exception {
        //given
        LadderInfo ladderInfo = new LadderInfo(PARTICIPANTS, HEIGHT);
        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new AlwaysTrueProvider());

        Method method = bridgeBuilder.getClass().getDeclaredMethod("isConnectableBridge", Bridge.class, int.class);
        method.setAccessible(true);
        Bridge bridge = new Bridge();

        //when
        bridge.addPoint(false);
        boolean isConnectable = (boolean) method.invoke(bridgeBuilder, bridge, 1);

        //then
        assertTrue(isConnectable);
    }

    @Test
    void 이전_다리에서_연결이_있는경우_연결하지않는다() throws Exception {
        //given
        LadderInfo ladderInfo = new LadderInfo(PARTICIPANTS, HEIGHT);
        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new AlwaysTrueProvider());

        Method method = bridgeBuilder.getClass().getDeclaredMethod("isConnectableBridge", Bridge.class, int.class);
        method.setAccessible(true);
        Bridge bridge = new Bridge();

        //when
        bridge.addPoint(true);
        boolean isConnectable = (boolean) method.invoke(bridgeBuilder, bridge, 1);

        //then
        assertFalse(isConnectable);
    }

    private static class AlwaysTrueProvider implements RandomBridgeProvider {

        @Override
        public boolean isConnectableBridgeByRandom() {
            return true;
        }
    }

}