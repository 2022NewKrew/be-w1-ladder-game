import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    public Ladder(int numOfPeople, int heightLadder) {
        rows = IntStream.range(0, heightLadder)
                .mapToObj(e -> new Row(numOfPeople - 1))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(Row::toString)
                .collect(Collectors.joining(""));
    }
}