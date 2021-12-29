import java.util.Random;

public class Ladder {
    private final int numPeople;
    private final int maxHeight;
    private final boolean[][] ladder;
    private static final Random rand = new Random();

    public Ladder(int numPeople, int maxHeight){
        this.numPeople = numPeople;
        this.maxHeight  = maxHeight;
        ladder = new boolean[maxHeight][numPeople-1];

        makeVerticalLadder();
    }

    private void makeVerticalLadder() {
        for (int i = 0; i < maxHeight; i++) {
           makeHorizontalLadder(i);
        }
    }
    private void makeHorizontalLadder(int height){
        for (int j = 0; j < numPeople - 1; j++) {
            ladder[height][j] = rand.nextBoolean();
        }
    }

    public boolean[][] getLadder() {
        return ladder;
    }
}

