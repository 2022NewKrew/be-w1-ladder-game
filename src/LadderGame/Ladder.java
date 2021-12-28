package LadderGame;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int ladderWidth, ladderHeight;
    private final Random randomInstance;

    private final ArrayList<ArrayList<Boolean>> hasRightLadder;

    public Ladder(int ladderWidth, int ladderHeight) {
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.randomInstance = new Random();
        this.hasRightLadder = makeHasRightLadder();
    }

    private ArrayList<ArrayList<Boolean>> makeHasRightLadder() {
        ArrayList<ArrayList<Boolean>> hasRightLadder = new ArrayList<>();

        for (int ladderRow = 0; ladderRow < ladderHeight; ladderRow++) {
            hasRightLadder.add(makeHasRightLadderRow());
        }
        return hasRightLadder;
    }

    private ArrayList<Boolean> makeHasRightLadderRow(){
        ArrayList<Boolean> ladderRow = new ArrayList<>();
        for (int ladderCol = 0; ladderCol < ladderWidth-1; ladderCol++){
            ladderRow.add(randomInstance.nextBoolean());
        }
        return ladderRow;
    }

    public void printLadder() {
        hasRightLadder.forEach((this::printLadderRow));
    }

    private void printLadderRow(ArrayList<Boolean> ladderRow){
        ladderRow.forEach(ladderCol->{
            System.out.print("|");
            System.out.print(printLocatedLadder(ladderCol));
        });
        System.out.println("|");
    }

    private String printLocatedLadder(Boolean chkLadder){
        if(chkLadder) return "-";
        return " ";
    }
}
