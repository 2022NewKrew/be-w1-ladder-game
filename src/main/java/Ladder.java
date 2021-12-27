import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Row> rows;

    public Ladder(int people, int heightLadder) {
        rows = new ArrayList<>();
        IntStream.range(0, heightLadder)
                .forEach(e -> rows.add(new Row(people)));
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(Row::toString)
                .collect(Collectors.joining(""));
    }
}