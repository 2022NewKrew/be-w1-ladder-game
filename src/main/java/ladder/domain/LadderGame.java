package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private static final String INPUT_DELIMITER = ",";
    private static final String SHOW_ALL_RESULT = "all";

    private List<LadderLine> gameBoard;
    private List<String> participantsNames;
    private List<String> gameResults;

    private int width;
    private int height;

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

    public void initGame(String namesInput, String resultsInput, int heightOfLadder,
        ConnectStrategy connectStrategy) {
        formatInputs(namesInput, resultsInput);

        if (participantsNames.size() != gameResults.size()) {
            throw new InputMismatchException();
        }

        width = participantsNames.size() - 1;
        height = heightOfLadder;

        if (width < 1) {
            throw new InputMismatchException("사다리 게임을 플레이하기 위해서는 사용자가 2명 이상 필요해요.");
        }

        makeGameBoard(connectStrategy);
    }

    public Map<String, String> getResultMap(String userName) {
        Map<String, String> resultMap = new HashMap<>();
        if (userName.equals(SHOW_ALL_RESULT)) {
            participantsNames.forEach(
                name -> resultMap.put(name, getResult(name)));
            return resultMap;
        }
        resultMap.put(userName, getResult(userName));
        return resultMap;
    }

    private String getResult(String userName) {
        for (int i = 0; i < participantsNames.size(); i++) {
            if (participantsNames.get(i).equals(userName)) {
                return getResultByIndex(i);
            }
        }
        return "사다리 게임에 참여한 사용자가 아니에요.";
    }

    private String getResultByIndex(int idx) {
        int location = idx;
        for (int i = 0; i < height; i++) {
            location = move(gameBoard.get(i), location);
        }
        return gameResults.get(location);
    }

    private int move(LadderLine line, int idx) {
        if (idx > 0 && line.getLine().get(idx - 1)) {
            return idx - 1;
        }
        if (idx < width && line.getLine().get(idx)) {
            return idx + 1;
        }
        return idx;
    }

    private void formatInputs(String namesInput, String resultsInput) {
        participantsNames = Arrays.stream(namesInput.split(INPUT_DELIMITER))
            .collect(Collectors.toList());
        gameResults = Arrays.stream(resultsInput.split(INPUT_DELIMITER))
            .collect(Collectors.toList());
    }

    private void makeGameBoard(ConnectStrategy connectStrategy) {
        gameBoard = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            gameBoard.add(makeLine(connectStrategy));
        }
    }

    private LadderLine makeLine(ConnectStrategy connectStrategy) {
        LadderLine line = new LadderLine();
        line.makeLine(connectStrategy, width);
        return line;
    }
}
