package laddergame;

import java.util.*;
import laddergame.Line;

public class Ladder {
    private final int ladderHeight;
    private final int numOfPeople;
    private ArrayList<Line> structure;

    public Ladder(int ladderHeight, int numOfPeople) {
        this.ladderHeight = ladderHeight;
        this.numOfPeople = numOfPeople;
        setStructure();
    }

    public void setStructure() {

        this.structure = new ArrayList<Line>();
        for (int i = 0; i < ladderHeight; i++) {
            Line newline = new Line(numOfPeople);
            structure.add(newline);
        }
    }

    public void printLadder() {
        for(Line thisLine : structure) {
            thisLine.printLine();
        }
    }
}
