import java.util.ArrayList;
import java.util.Random;

public class Ladder {

    private int personNum, ladderHeight;
    private boolean[][] ladder;

    public Ladder(int personNum, int ladderHeight) {
        this.personNum = personNum;
        this.ladderHeight = ladderHeight;
        this.ladder = new boolean[ladderHeight][personNum-1];
        makeLadder(personNum, ladderHeight);
    }

    void makeLadder(int personNum, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            makeLine(personNum,ladder[i]);
        }
    }

    void makeLine(int personNum, boolean[] line){
        Random random = new Random();
        for(int i=0; i<personNum - 1; i++){
            line[i] = random.nextBoolean();
        }
    }

    void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            System.out.print("|");
            printLine(i);
            System.out.println("");
        }
    }

    void printLine(int h){
        for (int i = 0; i < personNum - 1; i++) {
            System.out.print(printUnit(ladder[h][i]));
        }
    }

    String printUnit(boolean b){
        if(b){
            return "-|";
        }
        return " |";
    }

}
