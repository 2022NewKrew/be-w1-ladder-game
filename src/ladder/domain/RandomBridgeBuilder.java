package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomBridgeBuilder {
    private static Boolean preBridge = false;

    public List<Boolean> getRandomLadderRow(int width) {
        return Stream.generate(this::getRandomBridge)
                .limit(width)
                .collect(Collectors.toList());
    }

    private boolean getRandomBridge() {
        final Random random = new Random();
        preBridge = !preBridge && random.nextBoolean();
        return preBridge;
    }
}
