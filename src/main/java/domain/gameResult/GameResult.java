package domain.gameResult;

import domain.ladder.LadderFrame;
import domain.ladder.LadderFrameLine;
import dto.ladderDto.LadderDTO;

import java.util.*;

public class GameResult {
    private static final int MAX_LENGTH = 5;
    private final Map<String, String> result;
    private final List<String> terminal;

    public GameResult(LadderDTO ladderDTO, List<String> users, List<String> results) {
        GameResultPrecondition.checkUsers(users, MAX_LENGTH);
        GameResultPrecondition.checkResults(results, MAX_LENGTH, users.size());
        GameResultPrecondition.checkLadderDto(ladderDTO, users.size());
        terminal = new ArrayList<>(users);
        result = new HashMap<>();
        calculateResult(ladderDTO);
        makeResult(users, results);
    }

    private void calculateResult(LadderDTO ladder) {
        for (LadderFrameLine line : ladder.getLines()) {
            checkLine(line);
        }
    }

    private void checkLine(LadderFrameLine line) {
        int frameLength = line.getFrames().size();
        for (int index = 0; index < frameLength; index++) {
            checkFrame(line.getFrames().get(index), index);
        }
    }

    private void checkFrame(LadderFrame frame, int index) {
        if (frame == LadderFrame.BRIDGE) {
            Collections.swap(terminal, index, index + 1);
        }
    }

    private void makeResult(List<String> users, List<String> results) {
        for (String user : users) {
            result.put(user, results.get(terminal.indexOf(user)));
        }
    }

    public Map<String, String> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
