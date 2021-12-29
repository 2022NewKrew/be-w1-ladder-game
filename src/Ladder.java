package laddergame;

import java.util.*;
import laddergame.Line;

public class Ladder {
    private final int ladderHeight;
    private final int numOfPeople;
    private final String[] peopleArray;
    private ArrayList<Line> structure;

    public Ladder(int ladderHeight, int numOfPeople, String[] peopleArray) {
        this.ladderHeight = ladderHeight;
        this.numOfPeople = numOfPeople;
        this.peopleArray = peopleArray;
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
