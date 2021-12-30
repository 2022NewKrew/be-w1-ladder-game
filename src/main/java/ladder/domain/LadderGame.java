package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private static final String NAME_INPUT_DELIMITER = ",";

    private final RandomConnectStrategy randomConnectStrategy;

    private List<LadderLine> gameBoard;
    private List<String> participantsNames;

    private int width;
    private int height;

    public LadderGame() {
        randomConnectStrategy = new RandomConnectStrategy();
        gameBoard = new ArrayList<>();
    }

    public void run(String namesInput, int heightOfLadder) {
        try {
            initGame(namesInput, heightOfLadder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<LadderLine> getGameBoard() {
        return gameBoard;
    }

    public List<String> getParticipantsNames() {
        return participantsNames;
    }

    private void initGame(String namesInput, int heightOfLadder) {
        participantsNames = Arrays.stream(namesInput.split(NAME_INPUT_DELIMITER))
            .collect(Collectors.toList());
        width = participantsNames.size() - 1;
        height = heightOfLadder;

        if (width < 1) {
            throw new InputMismatchException("사다리 게임을 플레이하기 위해서는 사용자가 2명 이상 필요해요.");
        }

        makeGameBoard();
    }

    private void makeGameBoard() {
        gameBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            gameBoard.add(makeLine());
        }
    }

    private LadderLine makeLine() {
        LadderLine line = new LadderLine();
        line.makeLine(randomConnectStrategy, width);
        return line;
    }
}
