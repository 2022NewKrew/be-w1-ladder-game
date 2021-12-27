package ladder.view;

import java.util.Scanner;

public class Input {
    private static final String PLAYER_NUMBERS = "참여할 사람은 몇 명인가요?";
    private static final String MAXIMUM_HEIGHT_LADDER = "최대 사다리 높이는 몇 개인가요";

    private static final Scanner scanner = new Scanner(System.in);

    public static int PlayersNum() {
        System.out.println(PLAYER_NUMBERS);
        int n = scanner.nextInt();
        return n;
    }

    public static int MaximumLadderHeight() {
        System.out.println(MAXIMUM_HEIGHT_LADDER);
        int m = scanner.nextInt();
        return m;
    }
}
