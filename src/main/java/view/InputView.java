package view;

import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NUMBERS = "참여할 사람은 몇 명인가요?";
    private static final String MAXIMUM_HEIGHT_LADDER = "최대 사다리 높이는 몇 개인가요";

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPlayersNum() {
        System.out.println(PLAYER_NUMBERS);
        return scanner.nextInt();
    }

    public static int inputMaximumLadderHeight() {
        System.out.println(MAXIMUM_HEIGHT_LADDER);
        return scanner.nextInt();
    }
}
