package domain.ladder;

import domain.ladder.line.Line;
import domain.ladder.line.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(int column, int height, LineStrategy strategy) {
        this.ladder = createLadder(column - 1, height, strategy);
    }

    private List<Line> createLadder(int column, int height, LineStrategy strategy) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(Line.createToStrategy(strategy, column));
        }
        return ladder;
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }
}
