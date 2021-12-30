package keith.view;

import keith.Main;
import keith.domain.Ladder;
import keith.domain.Line;

import java.util.List;

public class LadderToString {
    private static final char COLUMN = '|';
    private static final String CONNECTED = "-".repeat(Main.MAX_NAME_LEN);
    private static final String NOT_CONNECTED = " ".repeat(Main.MAX_NAME_LEN);
    private static final String NAME_INDENT = "  ";
    private static final String LADDER_INDENT = " ".repeat(2 + Main.MAX_NAME_LEN / 2);
    private static final String LINE_BREAK = "\n";

    private final StringBuilder ladderString;

    public LadderToString(Ladder ladder) {
        this.ladderString = new StringBuilder();
        addNameString(ladder, this.ladderString);
        for (Line connectionRow : ladder.getConnections()) {
            addRowString(connectionRow.getPoints(), this.ladderString);
        }
    }

    private void addNameString(Ladder ladder, StringBuilder result) {
        result.append(NAME_INDENT);
        for (String name : ladder.getParticipants()) {
            // 왼쪽에 몫, 오른쪽에 몫+나머지만큼 공백
            int numberOfSpace = Main.MAX_NAME_LEN - name.length();
            int numberOfSpaceLeft = numberOfSpace / 2;
            int numberOfSpaceRight = numberOfSpaceLeft + numberOfSpace % 2;
            result.append(" ".repeat(numberOfSpaceLeft))
                    .append(name)
                    .append(" ".repeat(numberOfSpaceRight))
                    .append(" ");
        }
        result.append(LINE_BREAK);
    }

    private void addRowString(List<Boolean> connectionRow, StringBuilder result) {
        result.append(LADDER_INDENT);
        for (int i = 1; i < connectionRow.size() - 1; i++) {
            result.append(COLUMN)
                    .append(connectionRow.get(i) ? CONNECTED : NOT_CONNECTED);
        }
        result.append(COLUMN)
                .append(LINE_BREAK);
    }

    public String toString() {
        return this.ladderString.toString();
    }
}
