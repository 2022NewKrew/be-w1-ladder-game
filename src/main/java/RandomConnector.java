import java.util.Random;

public class RandomConnector {

    private final Random random;

    RandomConnector(long seed) {
        this.random = new Random(seed);
    }

    public void connect(Ladder ladder) {
        int line = random.nextInt(ladder.getPlayerNum() - 1);
        int height = random.nextInt(ladder.getMaxLadderHeight());

        while(isDuplicated(ladder, line, height)) {
            line = random.nextInt(ladder.getPlayerNum() - 1);
            height = random.nextInt(ladder.getMaxLadderHeight());
        }

        ladder.connect(line, line + 1, height);
    }

    private boolean isDuplicated(Ladder ladder, int line, int height) {
        return ladder.isConnected(line, line + 1, height);
    }
}
