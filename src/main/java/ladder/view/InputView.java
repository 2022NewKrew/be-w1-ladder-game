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

    public static String[] inputReward() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] rewards = scanner.nextLine().split(SPLIT_REGEX);
        System.out.println();
        return rewards;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        final int ladder = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return ladder;
    }

    public static String inputRewardPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?('춘식이'를 입력하면 전체 결과 출력 후 게임이 종료됩니다.)");
        final String playerName = scanner.nextLine();
        System.out.println();
        return playerName;
    }
}
