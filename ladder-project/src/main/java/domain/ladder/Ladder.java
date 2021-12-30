package domain.ladder;

import domain.ladder.line.Line;
import domain.ladder.line.RandomLineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(int column, int height) {
        this.ladder = createLadder(column - 1, height);
    }

    private List<Line> createLadder(int column, int height) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(Line.createToStrategy(new RandomLineStrategy(), column));
        }
        return ladder;
    }

    public List<List<Boolean>> getLadder() {
        return ladder.stream()
                .map(Line::getLines)
                .collect(Collectors.toList());
    }
}
