package main.java.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladderRows;
    private final int heightOfLadder;

    public Ladder(int widthOfLadder, int heightOfLadder) {
        this.heightOfLadder = heightOfLadder;
        ladderRows = new ArrayList<>();
        buildLadder(widthOfLadder);
    }

    private void buildLadder(int widthOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            ladderRows.add(new Line(widthOfLadder));
        }
    }

    public String printLadder(){
        StringBuilder sb = new StringBuilder();
        ladderRows.forEach(row -> sb.append(row).append('\n'));
        return sb.toString();
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public LadderComponent getLadderComponent(int row, int col){
        return ladderRows.get(row).getPointComponent(col);
    }
}