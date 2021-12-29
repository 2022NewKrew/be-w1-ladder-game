import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int numberOfLegs;
    private final List<Line> ladder;

    Ladder(int numberOfPeople, int height) {
        this.numberOfLegs = numberOfPeople;

        ladder = IntStream.range(0, height)
                .mapToObj(e -> new Line(numberOfLegs))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ladder.forEach(line -> sb.append(line).append("\n"));

        return sb.toString();
    }
}
