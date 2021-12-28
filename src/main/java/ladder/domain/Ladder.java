package ladder.domain;

import java.util.ArrayList;

public class Ladder {
    private final ArrayList<Line> lines;

    public Ladder(int rowCount, int columnCount){
        this.lines = new ArrayList<>();
        makeLadder(rowCount, columnCount);
    }

    private void makeLadder(int rowCount, int columnCount) {
        for (int i = 0; i < rowCount; i++) {
            lines.add(new Line(columnCount));
        }
    }

    public ArrayList<Line> getLines(){
        return this.lines;
    }
}
