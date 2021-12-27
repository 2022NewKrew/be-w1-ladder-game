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
            Piece piece = buildPiece(isOccurredBefore);
            builder.append(piece.getPiece());
            isOccurredBefore = piece.isOccurredBefore();
        }
        builder.append(LADDER_VERTICAL);
        return builder.toString();
    }

    private Piece buildPiece(boolean isOccurredBefore) {
        if (isOccurredBefore) {
            return new Piece(LADDER_EMPTY, false);
        }
        boolean isOccurredNow = random.nextBoolean();
        return new Piece(isOccurredNow ? LADDER_HORIZONTAL : LADDER_EMPTY, isOccurredNow);
    }

    private static class Piece {
        private final String piece;
        private final boolean isOccurredBefore;

        public Piece(String piece, boolean isOccurredBefore) {
            this.piece = piece;
            this.isOccurredBefore = isOccurredBefore;
        }

        public String getPiece() {
            return piece;
        }

        public boolean isOccurredBefore() {
            return isOccurredBefore;
        }
    }
}
