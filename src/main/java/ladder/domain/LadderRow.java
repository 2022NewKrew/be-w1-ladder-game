package ladder.domain;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRow {
    private final List<LadderBridge> bridges;

    LadderRow(int userNum) {
        BridgeGenerator bridgeGenerator = new BridgeGenerator();
        bridges = IntStream.range(0, userNum)
                .mapToObj(i -> {
                    if (i == userNum - 1) return LadderBridge.BRIDGE_DISCONNECTED;
                    return bridgeGenerator.generateBridge();
                })
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(Ladder.LADDER_LINE, Ladder.LADDER_LINE, Ladder.LADDER_LINE);
        IntStream.range(0, bridges.size() - 1)
                .mapToObj(bridges::get)
                .forEach(bridge -> joiner.add(bridge.line));
        return joiner.toString();
    }
}

