package domain.gameResult;

import java.util.*;

public class GameResult {
    public static GameResult INSTANCE;

    private static final int MAX_LENGTH = 5;
    private final Map<String, String> result;
    private final List<String> terminal;

    private GameResult(List<Integer> indexes, List<String> users, List<String> results) {
        GameResultPrecondition.checkUsers(users, MAX_LENGTH);
        GameResultPrecondition.checkResults(results, MAX_LENGTH, users.size());
        terminal = new ArrayList<>(users);
        result = new HashMap<>();

        moveByIndexes(indexes);
        makeResult(users, results);
    }

    public static synchronized GameResult getInstance() {
        return INSTANCE;
    }

    public static synchronized void makeGameResult(List<Integer> indexes, List<String> users, List<String> results) {
        INSTANCE = new GameResult(indexes, users, results);
    }

    private void moveByIndexes(List<Integer> indexes) {
        for (int index : indexes) {
            switchElementByIndex(index);
        }
    }

    private void switchElementByIndex(int index) {
        Collections.swap(terminal, index, index + 1);
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
