package ladder.view;

import ladder.domain.bridge.Bridge;
import ladder.domain.bridge.BridgeBuilder;
import ladder.domain.bridge.RandomBridgeProvider;
import ladder.domain.bridge.RandomBridgeProviderImpl;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderInfo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class LadderRendererTest {

    private static final String[] PARTICIPANTS = new String[]{"a", "bb", "ccc", "dddd", "eeeee"};
    private static final int HEIGHT = 5;
    private static final long SEED = System.currentTimeMillis();

    @Test
    void 입력받은_참여자의_이름을_정확히_출력한다() throws Exception {
        //given
        LadderInfo ladderInfo = new LadderInfo(PARTICIPANTS, HEIGHT);
        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new RandomBridgeProviderImpl(SEED));
        Ladder ladder = new Ladder(ladderInfo, bridgeBuilder.build());

        //when
        String result = LadderRenderer.render(ladder);

        //then
        assertTrue(result.startsWith("  a    bb    ccc  dddd  eeeee"));
    }

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