import java.util.List;

public class GameController {

    private static final IOController io = new IOController();
    private final Ladder ladder = new Ladder();
    private int numOfPlayers, numOfLine;
    private String[] username;

    //게임 시작 메서드
    public void startGame() {
        if (!inputParam()) return;

        generateLadder();
        printLadder();
    }

    //사다리 생성 메서드 호출
    private void generateLadder() {
        ladder.setLadder(numOfPlayers, numOfLine);
    }

    //사다리 라인 출력 메서드 호출
    private void printLadder() {
        List<Line> currentLadder = ladder.getLadder();
        if (currentLadder == null) return;

        for (Line line : currentLadder) {
            line.printLine();
        }
    }

    private boolean inputParam() {
        numOfPlayers = io.inputInt("참여할 사람은 몇 명인가요?");
        numOfLine = io.inputInt("최대 사다리 높이는 몇 개인가요?");
        username = io.inputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요").split(",");

        return isValidate();
    }

    //플레이어 수와 사다리 높이 유효성 검사
    private boolean isValidate() {
        return !(numOfPlayers <= 1 || numOfLine <= 0);
    }
}
