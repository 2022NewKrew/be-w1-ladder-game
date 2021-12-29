package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_REGEX = ",";

    private InputView() {
    }

    public static String[] inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] players = scanner.nextLine().split(SPLIT_REGEX);
        System.out.println();
        return players;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final int ladder = scanner.nextInt();
        System.out.println();
        return ladder;
    }
}
