package keith.view;

import keith.domain.Ladder;
import keith.domain.Line;

import java.util.List;

public class LadderToString {
    private static final char COLUMN = '|';
    private static final String CONNECTED = "-----";
    private static final String NOT_CONNECTED = "     ";

    private final StringBuilder ladderString;

    public LadderToString(Ladder ladder) {
        this.ladderString = new StringBuilder();
        addNameString(ladder, this.ladderString);
        for (Line connectionRow : ladder.getConnections()) {
            addRowString(connectionRow.getPoints(), this.ladderString);
        }
    }

    private void addNameString(Ladder ladder, StringBuilder result) {
        result.append("  ");
        for (String name : ladder.getParticipants()) {
            // 왼쪽에 몫, 오른쪽에 몫+나머지만큼 공백
            int numberOfSpace = 5 - name.length();
            result.append(" ".repeat(numberOfSpace / 2));
            result.append(name);
            result.append(" ".repeat(numberOfSpace / 2 + numberOfSpace % 2));
            result.append(" ");
        }
        result.append('\n');
    }

    private void addRowString(List<Boolean> connectionRow, StringBuilder result) {
        result.append("    ");
        for (Boolean isConnected : connectionRow) {
            result.append(COLUMN);
            result.append(isConnected ? CONNECTED : NOT_CONNECTED);
        }
        result.append(COLUMN);
        result.append('\n');
    }

    public String toString() {
        return this.ladderString.toString();
    }
}
