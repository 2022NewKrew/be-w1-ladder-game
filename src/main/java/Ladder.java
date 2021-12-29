import java.util.Random;

public class Ladder {
    private final int numOfPeople;
    private final int height;
    private final String[][] ladder;
    private Random random = new Random();

    Ladder(int numOfPeople, int height) {
        this.numOfPeople = numOfPeople;
        this.height = height;
        this.ladder = new String[height][numOfPeople-1];
        setLadder();
    }

    private void setLadder() {
        for(int i = 0; i < height; i++) {
            setLadderLine(i);
        }
    }

    private void setLadderLine(int row) {
        for(int j = 0; j < numOfPeople-1; j++) {
            ladder[row][j] = random.nextBoolean() ? "-" : " ";
        }
    }

    public String[][] getLadder() {
        return ladder;
    }

}
