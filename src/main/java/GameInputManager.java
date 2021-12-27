import java.util.Scanner;

public class GameInputManager {

    private final Scanner scanner = new Scanner(System.in);

    public GameStartInfo getInputGameStartInfo() {
        System.out.println("참여할 사람은 몇 명 인가요?");
        int gamePlayerNum = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxLadderHeight = scanner.nextInt();

        return new GameStartInfo(gamePlayerNum, maxLadderHeight);
    }
}
