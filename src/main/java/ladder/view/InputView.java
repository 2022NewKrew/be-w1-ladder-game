package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * @return {@link Scanner}로부터 입력받은 플레이어 목록
     */
    public List<Player> getPlayersFromScanner(String prompt) throws IllegalArgumentException {
        String input;
        List<Player> result = new ArrayList<>();
        System.out.println(prompt);
        while (result.size() <= 1) {
            System.out.println("** 한명 이상 입력해주세요 **");
            input = scanner.nextLine();
            result = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Player::new)
                    .collect(Collectors.toList());
        }
        if (result.stream().anyMatch(x -> x.getName().length() > LadderGame.PLAYER_NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException("** 플레이어 이름은 최대 " + LadderGame.PLAYER_NAME_LENGTH_LIMIT + "글자까지 입력 가능합니다 **");
        }
        return result;
    }

    /**
     * @return {@link Scanner}로부터 입력받은 양의 정수
     */
    public int getPositiveIntFromScanner(String prompt) {
        int input;
        System.out.print(prompt);
        while (!scanner.hasNextInt() || (input = scanner.nextInt()) <= 0) {
            System.out.println("** 양의 정수를 입력해주세요 **");
            scanner.next();
        }
        return input;
    }
}
