package ladder.stratgey;

import java.util.Random;

//사다리 브릿지 랜덤 생성 전략
public class LadderRandomStrategy implements LadderStrategy {
    private Random random = new Random();

    @Override
    public int getBridgeIdx() {
        return random.nextInt(1000);
    }

    @Override
    public int getLineIdx() {
        return random.nextInt(1000);
    }

    @Override
    public int getBridgeCntBound(int height, int playersCnt) {
        return height * (playersCnt - 1) / 2 + 1;
    }
}
