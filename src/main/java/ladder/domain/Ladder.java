package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    public static final String LADDER_LINE = "|";
    private final List<LadderRow> rows;

    public Ladder(int userNum, int height) {
        this.rows = IntStream.range(0, height)
                .mapToObj(e -> new LadderRow(userNum)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LadderRow row : rows) {
            builder.append(row).append("\n");
        }
        return builder.toString();
    }
}
