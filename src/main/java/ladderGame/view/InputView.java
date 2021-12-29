package ladderGame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String INPUT_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static String inputPlayersName() throws IOException {
        System.out.println(INPUT_PLAYERS_NAME);
        return input.readLine();
    }

    public static int inputLadderHeight() throws IOException {
        System.out.println(INPUT_LADDER_HEIGHT);
        return Integer.parseInt(input.readLine());
    }
}
