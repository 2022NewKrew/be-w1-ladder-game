package ladder.view;

import ladder.domain.bridge.BridgeBuilder;
import ladder.domain.bridge.RandomBridgeProviderImpl;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderRendererTest {

    private static final List<String> PARTICIPANTS = List.of("a", "bb", "ccc", "dddd", "eeeee");
    private static final List<String> RESULTS = List.of("1", "2", "3", "4", "5");
    private static final int HEIGHT = 5;
    private static final long SEED = System.currentTimeMillis();

    @Test
    void 입력받은_참여자의_이름과_결과들을_정확히_출력한다() throws Exception {
        //given
        LadderInfo ladderInfo = new LadderInfo(PARTICIPANTS, RESULTS, HEIGHT);
        BridgeBuilder bridgeBuilder = new BridgeBuilder(ladderInfo, new RandomBridgeProviderImpl(SEED));
        Ladder ladder = new Ladder(ladderInfo, bridgeBuilder.build());

        //when
        String result = LadderRenderer.render(ladder);

        //then
        assertTrue(result.startsWith("  a    bb    ccc  dddd  eeeee"));
        assertTrue(result.endsWith("1     2     3     4     5   \n"));
    }

}