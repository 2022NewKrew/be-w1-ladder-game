package ladder.view;

import ladder.domain.bridge.BridgeBuilder;
import ladder.domain.bridge.RandomBridgeProviderImpl;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderRendererTest {

    private static final String[] PARTICIPANTS = new String[]{"a", "bb", "ccc", "dddd", "eeeee"};
    private static final String[] RESULTS = new String[]{"1", "2", "3", "4", "5"};
    private static final int HEIGHT = 5;
    private static final long SEED = System.currentTimeMillis();

    @Test
    void 입력받은_참여자의_이름을_정확히_출력한다() throws Exception {
        //given
        LadderInfo ladderInfo = new LadderInfo(PARTICIPANTS, RESULTS, HEIGHT);
        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new RandomBridgeProviderImpl(SEED));
        Ladder ladder = new Ladder(ladderInfo, bridgeBuilder.build());

        //when
        String result = LadderRenderer.render(ladder);

        //then
        assertTrue(result.startsWith("  a    bb    ccc  dddd  eeeee"));
    }

}