package ladderGame.domain;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

/*
*   비즈니스 로직 관련 메소드를 모아놓은 클래스입니다.
* */
public class Input {
    private static final String MSG_INPUT_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MSG_INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    // 인스턴스 생성 막기
    private Input() {
    }

    public static final List<String> getPlayers() {
        String[] playersArr;
        do {
            System.out.println(MSG_INPUT_PLAYERS);
            playersArr = scanner.nextLine().split(",");
        } while(!checkPlayersName(playersArr));
        return Arrays.asList(playersArr);
    }

    public static final int getHeight() {
        final int height;
        System.out.println(MSG_INPUT_HEIGHT);
        height = scanner.nextInt();
        return height;
    }

    public static final void closeScanner() { scanner.close(); }

    private static final boolean checkPlayersName(String[] players) {
        boolean result = true;
        for(String player : players) {
            result &= (player.length() < 6);
        }
        return result;
    }
}
