package main.java.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Line {
    static final Random rand = new Random();
    private boolean isSuccessive = false;

    private final List<LadderComponent> points;

    public Line(int widthOfLadder) {
        points = new ArrayList<>();
        buildPoints(widthOfLadder);
    }

    private void buildPoints(int widthOfLadder) {
        points.add(LadderComponent.PADDING);
        for (int i = 0; i < widthOfLadder; i++) {
            points.add(fillLine(i));
        }
        points.add(LadderComponent.PADDING);
    }

    private LadderComponent fillLine(int colIdx) {
        if (colIdx % 2 == 0) {
            return LadderComponent.VERTICAL;
        }
        if (isSuccessive || rand.nextBoolean()) {
            isSuccessive = false;
            return LadderComponent.EMPTY;
        }
        isSuccessive = true;
        return LadderComponent.HORIZONTAL;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        points.forEach(col -> sb.append(col.getValue()));
        return sb.toString();
    }

    public LadderComponent getPointComponent(int col){
        return points.get(col);
    }
}