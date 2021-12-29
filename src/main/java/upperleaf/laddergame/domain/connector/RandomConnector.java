package upperleaf.laddergame.domain.connector;

import upperleaf.laddergame.domain.Ladder;

import java.util.Random;

/**
 * 사다리를 랜덤하게 이어주는 객체입니다.
 * 사다리의 line과 height을 랜덤하게 하나씩 뽑은뒤, 연결 가능한지 여부를 확인 후 연결합니다.
 * 연결이 불가능할 경우 다시 line과 height을 뽑습니다..
 */
public class RandomConnector {

    private final Random random;

    public RandomConnector(Random random) {
        this.random = random;
    }

    public void connect(Ladder ladder) {
        int line = random.nextInt(ladder.getPlayerNum() - 1);
        int height = random.nextInt(ladder.getMaxLadderHeight());

        while(!isConnectable(ladder, line, height)) {
            line = random.nextInt(ladder.getPlayerNum() - 1);
            height = random.nextInt(ladder.getMaxLadderHeight());
        }

        ladder.connectToRight(line, height);
    }

    private boolean isConnectable(Ladder ladder, int line, int height) {
        return ladder.isConnectableToRight(line, height);
    }
}
