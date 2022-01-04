package domain.gameResult;

import java.util.*;

public class GameResult {
    private static final int MAX_LENGTH = 5;

    private final Map<String, String> result;

    private GameResult(List<String> users, List<String> results) {
        GameResultPrecondition.checkUsers(users, MAX_LENGTH);
        GameResultPrecondition.checkResults(results, MAX_LENGTH, users.size());
        this.result = new HashMap<>();
    }

    public static GameResult getGameResult(List<Integer> indexes, List<String> users, List<String> results) {
        GameResult gameResult = new GameResult(users, results);
        gameResult.makeResult(indexes, users, results);
        return gameResult;
    }

    private void makeResult(List<Integer> indexes, List<String> users, List<String> results) {
        List<String> terminal = new ArrayList<>(users);
        moveByIndexes(indexes, terminal);
        for (String user : users) {
            result.put(user, results.get(terminal.indexOf(user)));
        }
    }

    private void moveByIndexes(List<Integer> indexes, List<String> terminal) {
        for (int index : indexes) {
            switchElementByIndex(index, terminal);
        }
    }

    private void switchElementByIndex(int index, List<String> terminal) {
        Collections.swap(terminal, index, index + 1);
    }

    public Set<Map.Entry<String, String>> getResult() {
        return Collections.unmodifiableSet(result.entrySet());
    }

    public String getTargetResult(String target) {
        if (result.containsKey(target)) {
            return result.get(target);
        }
        throw new IllegalArgumentException("유저명을 정확히 입력하셔야 합니다.");
    }
}
