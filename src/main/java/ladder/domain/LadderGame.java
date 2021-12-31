package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGame {
    private List<String> players;
    private final Ladder ladder;
    public final int PLAYER_NAME_LENGTH_LIMIT = 5;

    public List<String> getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public int getPlayerNameLengthLimit() {
        return PLAYER_NAME_LENGTH_LIMIT;
    }

    public LadderGame() {
        Scanner scanner = new Scanner(System.in);
        ladder = generateLadder(scanner);
    }

    /**
     * {@link Scanner}로부터 플레이어, 사다리 높이를 입력받아 {@link Ladder}를 만들어서 반환
     */
    private Ladder generateLadder(Scanner scanner) {
        while (true) {
            try {
                players = getPlayersFromScanner(scanner, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ");
                int height = getPositiveIntFromScanner(scanner, "사다리 높이는 몇개인가요? ");
                return new Ladder(players.size(), height);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * @return {@link Scanner}로부터 입력받은 플레이어 목록
     */
    private List<String> getPlayersFromScanner(Scanner scanner, String prompt) throws IllegalArgumentException {
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
        if (result.stream().anyMatch(x -> x.length() > PLAYER_NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException("** 플레이어 이름은 최대 " + PLAYER_NAME_LENGTH_LIMIT + "글자까지 입력 가능합니다 **");
        }
        return result;
    }

    /**
     * @return {@link Scanner}로부터 입력받은 양의 정수
     */
    private int getPositiveIntFromScanner(Scanner scanner, String prompt) {
        int input;
        System.out.print(prompt);
        while (!scanner.hasNextInt() || (input = scanner.nextInt()) <= 0) {
            System.out.println("** 양의 정수를 입력해주세요 **");
            scanner.next();
        }
        return input;
    }
}
