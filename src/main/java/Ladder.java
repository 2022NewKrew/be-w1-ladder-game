import java.util.Random;

public class Ladder {
    private final int participants;
    private final int height;
    private final boolean[][] ladder;

    public Ladder(int participants, int height){
        this.participants = participants;
        this.height  = height;
        ladder = new boolean[height][participants-1];

        makeLadder();
    }

    private void makeLadder() {
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < participants - 1; j++) {
                ladder[i][j] = random.nextBoolean();
            }
        }
    }

    public void printLadder(){
        String path = "|";

        for(int i=0; i<height; i++){
            for(int j = 0; j<participants-1; j++){
                System.out.print(path);
                System.out.print(isLadder(i,j));
            }
            System.out.println(path);
        }
    }

    private String isLadder(int i, int j){
        String path = "-";
        String space = " ";

        return ladder[i][j]? path : space;
    }
}

