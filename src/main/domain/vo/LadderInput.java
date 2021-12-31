package main.domain.vo;

public class LadderInput {

    public static final int MAX_STRING_LENGTH = 5;

    private final String[] playerNames;
    private final String[] results;
    private final int height;

    public LadderInput(String[] playerNames, String[] results, int height) {

        validateParams(playerNames, results);

        this.playerNames = playerNames;
        this.results = results;
        this.height = height;
    }

    private void validateParams(String[] playerNames, String[] results) {
        validateArrayLengthEquality(playerNames, results);
        for (int i = 0; i < playerNames.length; i++) {
            validateStringLengthOver(playerNames[i]);
            validateStringLengthOver(results[i]);
        }
    }

    private void validateArrayLengthEquality(String[] playerNames, String[] results) {
        if (playerNames.length != results.length) {
            throw new IllegalArgumentException("플레이어 수와 결과 개수가 다릅니다.");
        }
    }

    private void validateStringLengthOver(String s) {
        if (s.length() > MAX_STRING_LENGTH) {
            throw new IllegalArgumentException(s + "가 " + MAX_STRING_LENGTH + " 글자보다 큽니다.");
        }
    }

    public int getHeight() {
        return height;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public String[] getResults() {
        return results;
    }
}
