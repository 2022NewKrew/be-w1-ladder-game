import java.util.Random;

public class Ladder {
    private final int numPeople;
    private final int maxHeight;
    private final boolean[][] ladder;

    public Ladder(int numPeople, int maxHeight){
        this.numPeople = numPeople;
        this.maxHeight  = maxHeight;
        ladder = new boolean[maxHeight][numPeople-1];

        makeLadder();
    }

    private void makeLadder() {
        Random random = new Random();

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < numPeople - 1; j++) {
                ladder[i][j] = random.nextBoolean();
            }
        }
    }

    public void printLadder(){
        String vLine = "|";

        for(int i=0; i<maxHeight; i++){
            for(int j = 0; j< numPeople -1; j++){
                System.out.print(vLine);
                System.out.print(isLadder(i,j));
            }
            System.out.println(vLine);
        }
    }

    private String isLadder(int i, int j){
        String hLine = "-";
        String space = " ";

        return ladder[i][j]? hLine : space;
    }
}

