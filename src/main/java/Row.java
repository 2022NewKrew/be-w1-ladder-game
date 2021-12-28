import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Row {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-";
    private static final String EMPTY = " ";
    private final List<Boolean> bridges;

    public Row(int numOfBridges) {
        Random RANDOM = new Random();
        bridges = IntStream.range(0, numOfBridges)
                .mapToObj(i -> RANDOM.nextBoolean())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return PILLAR + bridges.stream()
                .map(e -> e ? BRIDGE : EMPTY)
                .collect(Collectors.joining(PILLAR))
                + PILLAR + "\n";
    }
}