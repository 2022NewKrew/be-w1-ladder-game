package step_2;

import java.util.Random;
import java.util.stream.IntStream;

public class LadderBuilder {
    private final Random random = new Random();

    private final StringBuilder buildedLadderShape;

    public LadderBuilder() {
        buildedLadderShape = new StringBuilder();
    }

    public void buildLadder(Ladder ladder) {
        IntStream.range(0, ladder.getHeight())
                .forEach(row -> buildLineOfLadder(ladder.getWidth()));
        ladder.setShape(buildedLadderShape);
    }

    private void buildLineOfLadder(int ladderWidth) {
        buildedLadderShape.append(LadderCharacter.COLOMN);
        IntStream.range(0, ladderWidth - 1)
                .forEach(col -> buildedLadderShape.append(getLadderConnection()));
        buildedLadderShape.append(LadderCharacter.CHANGE_LINE);
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
