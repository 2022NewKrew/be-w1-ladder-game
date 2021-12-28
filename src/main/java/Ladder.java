import java.security.SecureRandom;
import java.util.Random;

public class Ladder {
    private final int numPeople;
    private final int maxHeight;
    private final boolean[][] ladder;
    private final Random rand = new Random();

    public Ladder(int numPeople, int maxHeight){
        this.numPeople = numPeople;
        this.maxHeight  = maxHeight;
        ladder = new boolean[maxHeight][numPeople-1];

        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < numPeople - 1; j++) {
                ladder[i][j] = rand.nextBoolean();
            }
        }
    }

    public void printLadder(){
        StringBuilder ladder = new StringBuilder();
        String vLine = "|";

        for(int i=0; i<maxHeight; i++){
            for(int j = 0; j< numPeople -1; j++){
                ladder.append(vLine).append(isLadder(i, j));
            }
            ladder.append(vLine).append("\n");
        }
        System.out.println(ladder);
    }

    private String isLadder(int i, int j){
        String hLine = "-";
        String space = " ";

        return ladder[i][j]? hLine : space;
    }
}

