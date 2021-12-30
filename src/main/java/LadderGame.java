import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LadderGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ladder ladder = createLadderByPrompt(scanner);

        System.out.println(System.lineSeparator() + "실행결과" + System.lineSeparator());
        System.out.println(ladder.toPrettyString());
    }

    static Ladder createLadderByPrompt(Scanner scanner) {
        List<Player> players = createPlayersByPrompt(scanner);
        int ladderHeight = createLadderHeightByPrompt(scanner);
        return new Ladder(players, ladderHeight);
    }

    static List<Player> createPlayersByPrompt(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        List<Player> players = new ArrayList<>();
        for (String name : scanner.nextLine().split(",")) {
            try {
                players.add(new Player(name.strip()));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return players;
    }

    static int createLadderHeightByPrompt(Scanner scanner) {
        System.out.println(System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
