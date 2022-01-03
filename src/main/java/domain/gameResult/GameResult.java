package domain.gameResult;

import java.util.*;

public class GameResult {

    private static final int MAX_LENGTH = 5;
    private final Map<String, String> result;
    private final List<String> terminal;

    public GameResult(List<Integer> indexes, List<String> users, List<String> results) {
        GameResultPrecondition.checkUsers(users, MAX_LENGTH);
        GameResultPrecondition.checkResults(results, MAX_LENGTH, users.size());
        terminal = new ArrayList<>(users);
        result = new HashMap<>();

        moveByIndexes(indexes);
        makeResult(users, results);
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

    public Set<Map.Entry<String, String>> getResult() {
        return Collections.unmodifiableSet(result.entrySet());
    }

    public String getTargetResult(String target) {
        return result.get(target);
    }
}
