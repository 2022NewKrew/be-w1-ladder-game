import java.util.Scanner;
import ladder.domain.LadderGame;
import ladder.view.LadderGameView;

public class LadderGameApplication {

    private static final Scanner scanner = new Scanner(System.in);

    private LadderGame ladderGame;
    private LadderGameView ladderGameView;

    public static void main(String[] args) {
        LadderGameApplication application = new LadderGameApplication();

        application.initialize();
        application.run();
    }

    private void initialize() {
        ladderGame = new LadderGame();
        ladderGameView = new LadderGameView();

        String namesInput = inputName();
        String resultsInput = inputResult();
        int heightOfLadder = inputHeight();

        try {
            ladderGame.initGame(namesInput, resultsInput, heightOfLadder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() {
        try {
            ladderGameView.showGameBoard(ladderGame);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String inputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    private String inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    private int inputHeight() {
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }
}
