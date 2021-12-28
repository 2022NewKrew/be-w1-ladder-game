package step_2;

import java.util.Random;
import java.util.stream.IntStream;

public class LadderBuilder {
    private final Random random = new Random();

    private final StringBuilder ladder;

    public LadderBuilder() {
        ladder = new StringBuilder();
    }

    public Ladder buildLadder(int ladderWidth, int ladderHeight) {
        IntStream.range(0, ladderHeight)
                .forEach(row -> buildLineOfLadder(ladderWidth));
        return new Ladder(ladder);
    }

    private void buildLineOfLadder(int ladderWidth) {
        ladder.append(LadderCharacter.COLOMN);
        IntStream.range(0, ladderWidth - 1)
                .forEach(col -> ladder.append(getLadderConnection()));
        ladder.append(LadderCharacter.CHANGE_LINE);
    }

    private String getLadderConnection() {
        if (getLadderConnectionCondition())
            return LadderCharacter.CONNECTED;
        return LadderCharacter.NOT_CONNECTED;
    }

    private boolean getLadderConnectionCondition() {
        return random.nextBoolean();
    }
}
