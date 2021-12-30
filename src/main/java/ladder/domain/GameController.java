package ladder.domain;

import ladder.view.IOController;

import java.util.List;

public class GameController {

    private static final IOController io = new IOController();
    private final Ladder ladder = new Ladder();
    private int numOfPlayers, numOfLine;
    private String[] username;

    public void startGame() {
        if (!inputParam()) return;

        generateLadder();
        print();
    }

    private void generateLadder() {
        ladder.setLadder(numOfPlayers, numOfLine);
    }

    private void print() {
        List<Ladder.Line> currentLadder = ladder.getLadder();
        if (currentLadder == null) return;

        io.print(currentLadder, username);
    }

    private boolean inputParam() {
        numOfPlayers = io.inputInt("참여할 사람은 몇 명인가요?");
        numOfLine = io.inputInt("최대 사다리 높이는 몇 개인가요?");
        username = io.inputString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)").split(",");

        return isValidate();
    }

    private boolean isValidate() {
        return !(numOfPlayers <= 1 || numOfLine <= 0 || username.length != numOfPlayers);
    }
}
