package upperleaf.laddergame.game;

import upperleaf.laddergame.util.StringUtils;

import java.util.List;
import java.util.Scanner;

public class GameInputManager {

    private static final String SEPARATOR = ",";

    private final Scanner scanner = new Scanner(System.in);

    /**
    ** 게임에 시작할때 정보(참여하는 사람들의 이름, 사다리의 최대 높이)를 입력받습니다.
    ** 사람들의 이름은 쉼표를 통해 구분받아서 입력받습니다.
     */
    public GameStartInfo inputGameStartInfo() {
        String names = inputNames();
        String result = inputResults();
        int maxLadderHeight = inputMaxLadderHeight();

        List<String> playerNames = StringUtils.split(names, SEPARATOR);
        List<String> results = StringUtils.split(result, SEPARATOR);
        return new GameStartInfo(playerNames, results, maxLadderHeight);
    }

    private String inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(" + SEPARATOR + ")로 구분하세요). 사람의 이름은 최대 다섯글자로 해주세요.");
        return scanner.nextLine();
    }

    private String inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(" + SEPARATOR + ")로 구분하세요). 실행 결과는 최대 다섯글자로 해주세요.");
        return scanner.nextLine();
    }

    private int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
