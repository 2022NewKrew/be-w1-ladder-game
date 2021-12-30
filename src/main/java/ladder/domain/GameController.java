package ladder.domain;

import ladder.view.IOController;

import java.util.List;

public class GameController {

    private IOController io;
    private Ladder ladder;
    private int numOfPlayers, numOfLine;
    private List<String> username;

    public GameController() {
        io = new IOController();
        ladder = new Ladder();
    }

    public void startGame() {
        if (!inputParam()) return;

        generateLadder();
        print();
    }

    private void generateLadder() {
        ladder.setLadder(numOfPlayers, numOfLine);
    }

    private void print() {
        List<LadderLine> currentLadder = ladder.getLadder();
        if (currentLadder == null) return;

        io.print(currentLadder, username);
    }

    private boolean inputParam() {
        username = io.inputStringArray("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        numOfLine = io.inputInt("최대 사다리 높이는 몇 개인가요?");
        numOfPlayers = username.size();

        return isValidate();
    }

    private boolean isValidate() {
        return !(numOfPlayers <= 1 || numOfLine <= 0);
    }
}
