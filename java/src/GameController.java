import java.util.ArrayList;
import java.util.Scanner;

//게임 진행 역할을 수행하는 클래스
public class GameController {

    private final Scanner sc = new Scanner(System.in);
    private final LadderGenerator ladderGenerator = new LadderGenerator();

    private int players, height;

    //게임 시작 메서드
    public void startGame() {
        if (!inputParam()) return;

        generateLadder();
        printLadder();
    }

    //사다리 생성 메서드 호출
    private void generateLadder() {
        ladderGenerator.generateLadder(players, height);
    }

    //사다리 라인 출력 메서드 호출
    private void printLadder() {
        ArrayList<Line> currentLadder = ladderGenerator.getLadder();
        if (currentLadder == null) return;

        for (Line line : currentLadder) {
            line.printLine();
        }
    }

    private boolean inputParam() {
        players = inputInt("참여할 사람은 몇 명인가요?");
        height = inputInt("최대 사다리 높이는 몇 개인가요?");

        return isValidate();
    }

    private int inputInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

    //플레이어 수와 사다리 높이 유효성 검사
    private boolean isValidate() {
        return !(players <= 1 || height <= 0);
    }
}
