package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int WIDTH_CORRECTION = 1;
    private static final String NULL_SPACE = "";
    private static final String EMPTY_SPACE = "  ";
    private static final String NEW_LINE = "\n";

    private final List<LadderRow> bridges;

    public Ladder(int numPeople, int ladderHeight) {
        bridges = Stream.generate(() -> new LadderRow(numPeople - WIDTH_CORRECTION))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return bridges.stream()
                .map(LadderRow::toString)
                .collect(Collectors.joining(NEW_LINE + EMPTY_SPACE, EMPTY_SPACE, NULL_SPACE));
    }
}
