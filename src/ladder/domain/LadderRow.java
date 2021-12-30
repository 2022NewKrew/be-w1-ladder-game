package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderRow {
    private static final String PILLAR = "|";
    private static final String EMPTY = "     ";
    private static final String BRIDGE = "-----";

    private final List<Boolean> row;

    public LadderRow(List<Boolean> row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return row.stream()
                .map(bridge -> bridge ? BRIDGE : EMPTY)
                .collect(Collectors.joining(PILLAR, PILLAR, PILLAR));
    }
}
