package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(int numberOfPeople, int height) {
        ladder = IntStream.range(0, height)
                .mapToObj(e -> new Line(numberOfPeople))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Line> getLadderToList() {
        return ladder;
    }
}
