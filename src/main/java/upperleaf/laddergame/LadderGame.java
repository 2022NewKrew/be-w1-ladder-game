package upperleaf.laddergame;

import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.domain.LadderFlow;
import upperleaf.laddergame.domain.connector.LadderConnectionNumberPolicy;
import upperleaf.laddergame.domain.connector.RandomConnector;
import upperleaf.laddergame.game.GameInputManager;
import upperleaf.laddergame.game.GameStartInfo;
import upperleaf.laddergame.game.LadderFlowExecutor;
import upperleaf.laddergame.game.LadderGenerator;
import upperleaf.laddergame.game.view.LadderRenderer;
import upperleaf.laddergame.game.view.LadderView;

import java.util.Random;

public class LadderGame {

    /**
     * 1. 사용자로부터 게임 시작 정보를 입력받습니다.
     * 2. 사다리를 생성합니다.
     * 3. 사다리뷰를 렌더링합니다.
     * 4. 사다리뷰를 출력합니다.
     */
    public static void main(String[] args) {
        GameInputManager manager = new GameInputManager();
        GameStartInfo info = manager.inputGameStartInfo();

        RandomConnector connector = new RandomConnector(new Random(System.currentTimeMillis()));
        LadderGenerator generator = new LadderGenerator(connector, new LadderConnectionNumberPolicy());
        Ladder ladder = generator.generate(info);

        LadderRenderer renderer = new LadderRenderer();
        LadderView ladderView = renderer.render(ladder);
        ladderView.printResult();

        LadderFlowExecutor executor = new LadderFlowExecutor(new LadderFlow(ladder));
        executor.execute();
    }

}
