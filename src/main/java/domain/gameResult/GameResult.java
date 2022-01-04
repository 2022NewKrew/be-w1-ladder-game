package domain.gameResult;

import java.util.*;

public class GameResult {

    private static final int MAX_LENGTH = 5;
    private final Map<String, String> result;
    private final List<String> terminal;
    private final List<String> rewards;
    private final List<String> users;
    public GameResult(List<String> users, List<String> results) {
        GameResultPrecondition.checkUsers(users, MAX_LENGTH);
        GameResultPrecondition.checkResults(results, MAX_LENGTH, users.size());
        this.terminal = new ArrayList<>(users);
        this.users = new ArrayList<>(users);
        this.rewards = new ArrayList<>(results);
        this.result = new HashMap<>();
    }

    public void makeResult(List<Integer> indexes) {
        moveByIndexes(indexes);
        for (String user : users) {
            result.put(user, rewards.get(terminal.indexOf(user)));
        }
    }

    private void moveByIndexes(List<Integer> indexes) {
        for (int index : indexes) {
            switchElementByIndex(index);
        }
    }

    private void switchElementByIndex(int index) {
        Collections.swap(terminal, index, index + 1);
    }

    public Set<Map.Entry<String, String>> getResult() {
        return Collections.unmodifiableSet(result.entrySet());
    }

    public String getTargetResult(String target) {
        return result.get(target);
    }
}
