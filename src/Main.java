import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public static final char LADDER_FENCE = '|';
    public static final char LADDER_SPACE = ' ';
    public static final char LADDER_CONNECT = '-';

    public static void main(String[] args) {
        startLadderGame();
    }

    private static void startLadderGame() {
        int numParticipants = getInputInt("참여할 사람은 몇 명인가요?");
        int ladderHeight = getInputInt("최대 사다리 높이는 몇 개인가요?");

        char[][] ladderInfo = makeLadder(numParticipants, ladderHeight);
        printLadder(ladderInfo);
    }

    private static int getInputInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

    private static char[][] makeLadder(int numParticipants, int ladderHeight) {
        char[][] ladderInfo = new char[ladderHeight][numParticipants - 1];
        for (char[] ladderRow : ladderInfo) {
            for (int i = 0; i < ladderRow.length; i++) {
                ladderRow[i] = random.nextBoolean() ? LADDER_CONNECT : LADDER_SPACE;
            }
        }
        return ladderInfo;
    }

    private static void printLadder(char[][] ladderInfo) {
        StringBuilder sb = new StringBuilder();
        for (char[] ladderRow : ladderInfo) {
            sb.append("\n").append(LADDER_FENCE);
            for (char ladderCell : ladderRow) {
                sb.append(ladderCell).append(LADDER_FENCE);
            }
        }
        System.out.println(sb);
    }
}
