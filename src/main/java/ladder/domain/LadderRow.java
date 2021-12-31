package ladder.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRow {
    private final List<LadderBridge> bridges;

    LadderRow(int userNum) {
        BridgeGenerator bridgeGenerator = new BridgeGenerator();
        bridges = IntStream.range(0, userNum - 1).mapToObj(e -> bridgeGenerator.generateBridge()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(Ladder.LADDER_LINE, Ladder.LADDER_LINE, Ladder.LADDER_LINE);
        for (LadderBridge bridge : bridges) {
            joiner.add(bridge.line);
        }
        return joiner.toString();
    }
}

