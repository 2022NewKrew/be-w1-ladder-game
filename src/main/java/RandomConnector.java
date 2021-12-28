import java.util.Random;

public class RandomConnector {

    private final Random random;

    RandomConnector(long seed) {
        this.random = new Random(seed);
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
