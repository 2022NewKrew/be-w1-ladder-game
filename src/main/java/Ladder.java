import java.util.ArrayList;
import java.util.Random;

public class Ladder {

    private int personNum, ladderHeight;
    int[][] ladder;
    //ArrayList<ArrayList<Integer>> ladder = new ArrayList<ArrayList<Integer>>();

    public Ladder(int personNum, int ladderHeight) {
        this.personNum = personNum;
        this.ladderHeight = ladderHeight;
        for(int i=0; i<personNum; i++){
            for(int j=0; j<ladderHeight; j++){
            }
        }
        this.ladder = new int[personNum-1][ladderHeight];
        setLadder(personNum,ladderHeight);
    }

    void setLadder(int personNum, int ladderHeight){
        for(int i=0; i<personNum-1; i++){
            for(int j=0; j<ladderHeight; j++){
                int n = (int)(Math.random()*2);
                if(n == 0){
                    this.ladder[i][j] = 1;
                }
            }
        }
    }

    void printLadder(){
        for(int i=0; i<ladderHeight; i++){
            System.out.print("|");
            for(int j=0; j<personNum-1; j++){
                if(this.ladder[j][i]==1){
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
