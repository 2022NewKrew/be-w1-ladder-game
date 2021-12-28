import java.util.Random;

public class LadderGame {
    private static final String LADDER_EMPTY = " ";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZONTAL = "-";

    private final Integer numberOfPlayers;
    private final Integer heightOfLadder;
    private final Random random;

    public LadderGame(Integer numberOfPlayers, Integer heightOfLadder, Random random) {
        this.numberOfPlayers = numberOfPlayers;
        this.heightOfLadder = heightOfLadder;
        this.random = random;
    }

    public String buildLadder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < heightOfLadder; i++) {
            builder.append(buildLine());
            builder.append('\n');
        }
        return builder.toString();
    }

    private String buildLine() {
        StringBuilder builder = new StringBuilder();
        boolean isOccurredBefore = false;
        for (int i = 0; i < numberOfPlayers - 1; i++) {
            builder.append(LADDER_VERTICAL);
            String piece = buildPiece(isOccurredBefore);
            isOccurredBefore = piece.equals(LADDER_HORIZONTAL);
            builder.append(piece);
        }
        builder.append(LADDER_VERTICAL);
        return builder.toString();
    }

    private String buildPiece(boolean isOccurredBefore) {
        if (isOccurredBefore) {
            return LADDER_EMPTY;
        }
        return random.nextBoolean() ? LADDER_HORIZONTAL : LADDER_EMPTY;
    }
}
