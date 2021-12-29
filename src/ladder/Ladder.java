package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    static Random rand = new Random();

    private final int height;
    private final int width;
    private final List<List<Character>> ladder;

    public Ladder(int people, int height) {
        this.height = height;
        width = people * 2 - 1;
        ladder = new ArrayList<>();
        buildLadder();
    }

    private void buildLadder() {
        for (int i = 0; i < height; i++) {
            ladder.add(buildRow());
        }
    }

    private List<Character> buildRow() {
        List<Character> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(fillLine(i));
        }
        return row;
    }

    private Character fillLine(int colIdx) {
        if (colIdx % 2 == 0) {
            return LadderComponent.VERTICAL.getValue();
        }
        if(rand.nextBoolean()){
            return LadderComponent.HORIZONTAL.getValue();
        }
        return LadderComponent.EMPTY.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladder.forEach(row -> {
            row.forEach(sb::append);
            sb.append('\n');
        });
        return sb.toString();
    }
}
