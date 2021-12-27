import java.security.SecureRandom;
import java.util.Scanner;

public class Main {
    private static final byte[] SEED = {26, -69, 76, -110, -94, 80, 126, -68, 100, 1, 68, -32, 5, 95, -11, -58, 123, -86, 126, 47};

    public static void main(String[] args) {
        LadderGame ladderGame = initLadderGameByInput();
        System.out.println(ladderGame.buildLadder());
    }

    private static LadderGame initLadderGameByInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = scanner.nextInt();
        System.out.println();

        return new LadderGame(numberOfPlayers, heightOfLadder, new SecureRandom(SEED));
    }
}
