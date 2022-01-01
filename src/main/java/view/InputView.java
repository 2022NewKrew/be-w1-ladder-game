package view;

import domain.Player;
import validator.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAXIMUM_HEIGHT_LADDER = "최대 사다리 높이는 몇 개인가요";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> inputPlayerNames() {
        List<Player> players = new ArrayList<>();
        System.out.println(PLAYER_NAMES);
        String namesBeforeDefined = scanner.next();
        String[] namesAfterDefined = namesBeforeDefined.split(",");
        for (String nameAfterDefined : namesAfterDefined) {
            Player player = stringToPlayer(nameAfterDefined);
            players.add(player);
        }
        return players;
    }

    public static Player stringToPlayer(String nameAfterDefined) {
        Player player = new Player(nameAfterDefined);
        Validation.validatePlayerName(new Player(nameAfterDefined));
        return player;
    }

    public static int inputMaximumLadderHeight() {
        System.out.println(MAXIMUM_HEIGHT_LADDER);
        return scanner.nextInt();
    }
}
