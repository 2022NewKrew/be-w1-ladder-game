package ladderGame.domain;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

/*
*   비즈니스 로직 관련 메소드를 모아놓은 클래스입니다.
* */
public final class Input {
    private static final String MSG_INPUT_PLAYERS = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MSG_INPUT_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String MSG_INPUT_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MSG_INPUT_SELECT = "\n결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    // 인스턴스 생성 막기
    private Input() {
    }

    public static List<String> getPlayers() {
        String[] playersArr;
        do {
            System.out.println(MSG_INPUT_PLAYERS);
            playersArr = scanner.nextLine().split(",");
        } while(!checkPlayersName(playersArr));
        return Arrays.asList(playersArr);
    }

    public static List<String> getResult(int numberOfPlayers) {
        String[] result;
        do {
            System.out.println(MSG_INPUT_RESULT);
            result = scanner.nextLine().split(",");
        } while(result.length != numberOfPlayers);
        return Arrays.asList(result);
    }

    public static int getHeight() {
        System.out.println(MSG_INPUT_HEIGHT);
        return scanner.nextInt();
    }

    public static String getSelectedPlayer() {
        System.out.println(MSG_INPUT_SELECT);
        return scanner.next();
    }

    public static void closeScanner() { scanner.close(); }

    private static boolean checkPlayersName(String[] players) {
        boolean result = true;
        for(String player : players) {
            result &= (player.length() < 6);
        }
        return result;
    }
}
