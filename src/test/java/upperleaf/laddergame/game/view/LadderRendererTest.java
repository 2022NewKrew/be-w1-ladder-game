package upperleaf.laddergame.game.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.game.GameStartInfo;
import upperleaf.laddergame.game.GameStartInfoFactory;
import upperleaf.laddergame.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class LadderRendererTest {

    final LadderRenderer ladderRenderer = new LadderRenderer();

    Ladder ladder;

    @BeforeEach
    void fixture() {
        GameStartInfoFactory factory = new GameStartInfoFactory();
        GameStartInfo info = factory.create();
        ladder = new Ladder(info);
        ladder.connectToRight(0, 0);
    }

    @DisplayName("LadderRenderer를 통해서 출력할 결과물에는 플레이어들의 이름이 전부 포함되어 있다.")
    @Test
    void ladderViewContainsPlayerName() {
        LadderView ladderView = ladderRenderer.render(ladder);
        for (String player : ladder.getPlayerNames()) {
            assertTrue(ladderView.getResult().contains(player));
        }
    }

    @DisplayName("LadderRenderer를 통해서 출력할 결과물에는 사다리간 간격이 정해져있다.")
    @Test
    void ladderViewTest() {
        LadderView ladderView = ladderRenderer.render(ladder);

        assertTrue(ladderView.getResult().contains(StringUtils.times(LadderRenderer.EMPTY, LadderRenderer.LENGTH)));
        assertTrue(ladderView.getResult().contains(StringUtils.times(LadderRenderer.CONNECT, LadderRenderer.LENGTH)));

        int overLength = LadderRenderer.LENGTH + 1;
        ladderView.printResult();
        assertFalse(ladderView.getResult().contains(StringUtils.times(LadderRenderer.EMPTY, overLength)));
        assertFalse(ladderView.getResult().contains(StringUtils.times(LadderRenderer.CONNECT, overLength)));
    }
}