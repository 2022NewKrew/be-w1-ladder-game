import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public static final char LADDER_LINE = '|';
    public static final char LADDER_EMPTY = ' ';
    public static final char LADDER_EXIST = '-';

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
                ladderRow[i] = random.nextBoolean() ? LADDER_EXIST : LADDER_EMPTY;
            }
        }
        return ladderInfo;
    }

    private static void printLadder(char[][] ladderInfo) {
        StringBuilder sb = new StringBuilder();
        for (char[] ladderRow : ladderInfo) {
            sb.append("\n").append(LADDER_LINE);
            for (char ladderCell : ladderRow) {
                sb.append(ladderCell).append(LADDER_LINE);
            }
        }
        System.out.println(sb);
    }
}
