package ladder.view;

import ladder.domain.Player;
import ladder.domain.Result;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";

    private final Scanner scanner;
    private final int maxUserNameLength;

    public InputView(int maxUserNameLength) {
        this.maxUserNameLength = maxUserNameLength;

        scanner = new Scanner(System.in);
    }

    public List<Player> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputPlayers = scanner.nextLine().split(DELIMITER);

        return Arrays.stream(inputPlayers)
                .map(inputPlayer -> new Player(inputPlayer, maxUserNameLength))
                .collect(Collectors.toList());
    }

    public List<Result> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] inputResults = scanner.nextLine().split(DELIMITER);

        return Arrays.stream(inputResults)
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public int inputMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputResultPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
