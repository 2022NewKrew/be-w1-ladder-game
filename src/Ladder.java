import java.util.Random;

public class Ladder {
    public static final char LADDER_LINE = '|';
    public static final char LADDER_EMPTY = ' ';
    public static final char LADDER_EXIST = '-';

    private static final Random random = new Random();

    private final int numOfPlayer;
    private final int height;
    private final char[][] connections;

    public Ladder(int numOfPlayer, int height) {
        this.numOfPlayer = numOfPlayer;
        this.height = height;
        this.connections = new char[height][numOfPlayer - 1];
    }

    public void connect() {
        for (char[] ladderRow : connections) {
            for (int i = 0; i < ladderRow.length; i++) {
                ladderRow[i] = random.nextBoolean() ? LADDER_EXIST : LADDER_EMPTY;
            }
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (char[] ladderRow : connections) {
            sb.append("\n").append(LADDER_LINE);
            for (char ladderCell : ladderRow) {
                sb.append(ladderCell).append(LADDER_LINE);
            }
        }
        System.out.println(sb);
    }
}
