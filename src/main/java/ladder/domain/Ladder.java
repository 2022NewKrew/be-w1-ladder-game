package ladder.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final String LADDER_LINE = "|";
    private final List<LadderRow> rows;

    public Ladder(int userNum, int height) {
        this.rows = IntStream.range(0, height)
                .mapToObj(e -> new LadderRow(userNum))
                .collect(Collectors.toUnmodifiableList());
    }

    public void print() {
        StringJoiner joiner = new StringJoiner("\n");
        rows.forEach(row -> joiner.add(row.toString()));
        System.out.println(joiner);
    }
}
