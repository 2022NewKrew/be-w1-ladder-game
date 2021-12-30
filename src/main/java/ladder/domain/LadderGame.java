package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private static final String INPUT_DELIMITER = ",";

    private final RandomConnectStrategy randomConnectStrategy;

    private List<LadderLine> gameBoard;
    private List<String> participantsNames;
    private List<String> gameResults;

    private int width;
    private int height;

    public LadderGame() {
        randomConnectStrategy = new RandomConnectStrategy();
        gameBoard = new ArrayList<>();
    }

    public List<LadderLine> getGameBoard() {
        return gameBoard;
    }

    public List<String> getParticipantsNames() {
        return participantsNames;
    }

    public List<String> getGameResults() {
        return gameResults;
    }

    public boolean isAvailable() {
        return gameBoard != null && !gameBoard.isEmpty();
    }

    public void initGame(String namesInput, String resultsInput, int heightOfLadder) {
        formatInputs(namesInput, resultsInput);

        if (participantsNames.size() != gameResults.size()) {
            throw new InputMismatchException("사다리 게임에 참여한 사용자와 결과는 수가 일치해야 해요.");
        }

        width = participantsNames.size() - 1;
        height = heightOfLadder;

        if (width < 1) {
            throw new InputMismatchException("사다리 게임을 플레이하기 위해서는 사용자가 2명 이상 필요해요.");
        }

        makeGameBoard();
    }

    private void formatInputs(String namesInput, String resultsInput) {
        participantsNames = Arrays.stream(namesInput.split(INPUT_DELIMITER))
            .collect(Collectors.toList());
        gameResults = Arrays.stream(resultsInput.split(INPUT_DELIMITER))
            .collect(Collectors.toList());
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
