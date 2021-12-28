import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private int numOfPeople;
    private int height;
    private String[][] ladder;

    Ladder(int numOfPeople, int height) {
        this.numOfPeople = numOfPeople;
        this.height = height;
        this.ladder = new String[height][numOfPeople*2-1];
        setLadder();
    }

    private void setLadder() {
        Random random = new Random();
        for(int i = 0; i < height; i++) {
            ladder[i][0] = "|";
            for(int j = 1; j < numOfPeople*2-1; j+=2) {
                ladder[i][j] = random.nextBoolean() ? "-" : " ";
                ladder[i][j+1] = "|";
            }
        }
    }

    public void show() {
        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < numOfPeople*2-1; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }

}
