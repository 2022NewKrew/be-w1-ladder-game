package main;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    // instance variable
    private int peopleCount;
    private int ladderHeight;
    private List<Line> lines;

    // Constructor
    public Ladder(int peopleCount, int ladderCount) {
        this.peopleCount = peopleCount;
        this.ladderHeight = ladderCount;
        this.lines = new ArrayList<>();
    }

    public void addLadderLine(Line ladderLine) {
        this.lines.add(ladderLine);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
