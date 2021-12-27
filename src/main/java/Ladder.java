import java.util.ArrayList;
import java.util.Random;

public class Ladder {

    private int personNum, ladderHeight;
    private boolean[][] ladder;

    public Ladder(int personNum, int ladderHeight) {
        this.personNum = personNum;
        this.ladderHeight = ladderHeight;
        this.ladder = new boolean[personNum-1][ladderHeight];
        setLadder(personNum,ladderHeight);
    }

    void setLadder(int personNum, int ladderHeight){
        Random random = new Random();
        for(int i=0; i<personNum-1; i++){
            for(int j=0; j<ladderHeight; j++){
                if(random.nextBoolean()){
                    ladder[i][j] = true;
                }
            }
        }
    }

    void printLadder(){
        for(int i=0; i<ladderHeight; i++){
            System.out.print("|");
            for(int j=0; j<personNum-1; j++){
                if(ladder[j][i]){
                    System.out.print("-|");
                }
                else{
                    System.out.print(" |");
                }
            }
            System.out.println("");
        }
    }

}
