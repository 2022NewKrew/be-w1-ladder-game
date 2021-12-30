package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGame {
    public static final int MAX_PLAYER_NAME_LENGTH = 5;

    private List<String> players;

    /**
     * 사다리 생성 및 출력
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Ladder ladder = generateLadder(scanner);

        System.out.println("** 실행 결과 **");
        printPlayers();
        System.out.println(ladder);
    }

    /**
     * {@link Scanner}로부터 플레이어, 사다리 높이를 입력받아 {@link Ladder}를 만들어서 반환
     */
    private Ladder generateLadder(Scanner scanner) {
        players = getPlayersFromScanner(scanner, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ");
        int height = getPositiveIntFromScanner(scanner, "사다리 높이는 몇개인가요? ");

        return new Ladder(players.size(), height);
    }

    /**
     * @return {@link Scanner}로부터 입력받은 플레이어 목록
     */
    private List<String> getPlayersFromScanner(Scanner scanner, String prompt) {
        String input;
        List<String> result = new ArrayList<>();
        System.out.println(prompt);
        while (result.size() <= 1) {
            System.out.println("** 한명 이상 입력해주세요 **");
            input = scanner.nextLine();
            result = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
        return result;
    }

    /**
     * @return {@link Scanner}로부터 입력받은 양의 정수
     */
    private static int getPositiveIntFromScanner(Scanner scanner, String prompt) {
        int input;
        System.out.print(prompt);
        while (!scanner.hasNextInt() || (input = scanner.nextInt()) <= 0) {
            System.out.println("** 양의 정수를 입력해주세요 **");
            scanner.next();
        }
        return input;
    }

    private void printPlayers() {
        for (String player: players) {
            System.out.printf("%-6s", player);
        }
        System.out.println();
    }
}
