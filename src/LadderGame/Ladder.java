package LadderGame;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    public int ladderWidth, ladderHeight;
    public ArrayList<ArrayList<Boolean>> hasRightLadder;

    public Ladder(int ladderWidth, int ladderHeight) {
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.hasRightLadder = makeRightLadder();
    }

    public ArrayList<ArrayList<Boolean>> makeRightLadder() {
        ArrayList<ArrayList<Boolean>> hasRightLadder = new ArrayList<>();

        for (int ladderRow = 0; ladderRow < ladderHeight; ladderRow++) {
            hasRightLadder.add(makeLadderRow());
        }
        return hasRightLadder;
    }

    public ArrayList<Boolean> makeLadderRow(){
        Random randomInstance = new Random();
        ArrayList<Boolean> chkLine = new ArrayList<>();
        for (int ladderCol = 0; ladderCol < ladderWidth-1; ladderCol++){
            chkLine.add(randomInstance.nextBoolean());
        }
        return chkLine;
    }

    public void printLadder() {
        hasRightLadder.forEach((this::printLadderRow));
    }

    public void printLadderRow(ArrayList<Boolean> ladderRow){
        ladderRow.forEach(chkLadder->{
            System.out.print("|");
            System.out.print(isLadderLocated(chkLadder));
        });
        System.out.println("|");
    }

    public char isLadderLocated(Boolean chkLadder){
        if(chkLadder) return '-';
        return ' ';
    }
}
