import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderRow {
    private static final String PILLAR = "|";
    private static final String EMPTY = "     ";
    private static final String BRIDGE = "-----";

    private final List<Boolean> row;
    private static Boolean preBridge = false;

    public LadderRow(int width) {
        row = Stream.generate(this::getRandomBridge)
                .limit(width)
                .collect(Collectors.toList());
    }

    private boolean getRandomBridge() {
        final Random random = new Random();
        preBridge = !preBridge && random.nextBoolean();
        return preBridge;
    }

    @Override
    public String toString() {
        return row.stream()
                .map(bridge -> bridge ? BRIDGE : EMPTY)
                .collect(Collectors.joining(PILLAR, PILLAR, PILLAR));
    }
}
