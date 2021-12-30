package main.java.domain;

import java.util.ArrayList;
import java.util.List;

import static main.java.util.Util.centerString;

public class Ladder {
    private final int MAX_NAME_LENGTH = 6;

    // instance variable
    private List<String> peopleNameList;
    private int ladderHeight;
    private List<Line> lines;

    // Constructor
    public Ladder(List<String> peopleNameList, int ladderCount) {
        this.peopleNameList = peopleNameList;
        this.ladderHeight = ladderCount;
        this.lines = new ArrayList<>();
    }

    public void addLadderLine(Line ladderLine) {
        this.lines.add(ladderLine);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String name : this.peopleNameList) {
            sb.append(centerString(this.MAX_NAME_LENGTH, name));
        }
        sb.append("\n");

        for (int i = 0; i < lines.size(); i++) {
            sb.append("  " + lines.get(i).toString() + "\n");
        }
        return sb.toString();
    }
}