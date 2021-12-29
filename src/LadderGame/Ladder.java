package LadderGame;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final static String VERTICAL_LINE = "|";
    private final static String HORIZONTAL_LINE = "-----";
    private final static String BLANK = "     ";

    private final int ladderWidth, ladderHeight;
    private final Random random;

    private final ArrayList<Line> hasRightLadder;

    public Ladder(int ladderWidth, int ladderHeight) {
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.random = new Random();
        this.hasRightLadder = makeHasRightLadder();
    }

    private ArrayList<Line> makeHasRightLadder() {
        ArrayList<Line> hasRightLadder = new ArrayList<>();
        for (int ladderRow = 0; ladderRow < ladderHeight; ladderRow++) {
            Line hasRightLadderRow = new Line(ladderWidth, random);
            hasRightLadder.add(hasRightLadderRow);
        }
        return hasRightLadder;
    }

    public void printLadder() {
        hasRightLadder.forEach((this::printLadderRow));
    }

    private void printLadderRow(Line ladderRow){
        ladderRow.points.forEach(ladderCol -> {
            System.out.print(VERTICAL_LINE);
            System.out.print(printLocatedLadder(ladderCol));
        });
        System.out.println(VERTICAL_LINE);
    }

    private String printLocatedLadder(Boolean chkLadder){
        if(chkLadder) return HORIZONTAL_LINE;
        return BLANK;
    }
}
