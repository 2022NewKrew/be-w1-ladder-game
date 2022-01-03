package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderInput {
    final static Scanner scanner = new Scanner(System.in);

    public static List<String> getPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.next().split(","));
    }

    public static int getPlayersStepOne() {
        System.out.println("참여할 사람은 몇명인가요?");
        return scanner.nextInt();
    }

    public static int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}
