package be.w1.ladder_game.view;

import java.util.Scanner;

public class InputView {
    private static final String PEOPLE_COUNT_INPUT_MESSAGE = "참여할 사람은 몇 명인가요?";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {}

    public String getPlayersName() {
        System.out.println(PLAYER_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public int getPeopleCount() {
        System.out.println(PEOPLE_COUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    public int getLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
