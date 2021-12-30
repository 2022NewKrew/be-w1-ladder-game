package keith.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import keith.domain.Ladder;
import keith.domain.Line;

public class LadderToString {
    private static final char COLUMN = '|';
    private static final String CONNECTED = "-".repeat(Ladder.MAX_NAME_LEN);
    private static final String NOT_CONNECTED = " ".repeat(Ladder.MAX_NAME_LEN);
    private static final String SPACE = " ";
    private static final String NAME_INDENT = SPACE.repeat(2);
    private static final String LADDER_INDENT = SPACE.repeat(2 + Ladder.MAX_NAME_LEN / 2);
    private static final String LINE_BREAK = "\n";

    private final StringBuilder ladderString;

    public LadderToString(Ladder ladder) {
        this.ladderString = new StringBuilder();
        addStringRow(ladder.getParticipants(), this.ladderString);
        for (Line connectionRow : ladder.getConnections()) {
            addLadderRow(connectionRow.getPoints(), this.ladderString);
        }
        addStringRow(ladder.getDestinations(), this.ladderString);
    }

    private void addStringRow(List<String> list, StringBuilder result) {
        Stream<String> stream = list.stream()
                .map(name -> name.substring(0, Math.min(Ladder.MAX_NAME_LEN, name.length())));
        List<String> nameToPrint = stream.collect(Collectors.toList());

        result.append(NAME_INDENT);
        for (String name : nameToPrint) {
            addString(name, result);
        }
        result.append(LINE_BREAK);
    }

    private void addString(String name, StringBuilder result) {
        // 왼쪽에 몫, 오른쪽에 몫+나머지만큼 공백
        int numberOfSpace = Ladder.MAX_NAME_LEN - name.length();
        int numberOfSpaceLeft = numberOfSpace / 2;
        int numberOfSpaceRight = numberOfSpaceLeft + numberOfSpace % 2 + 1;
        result.append(SPACE.repeat(numberOfSpaceLeft))
                .append(name)
                .append(SPACE.repeat(numberOfSpaceRight));
    }

    private void addLadderRow(List<Boolean> connectionRow, StringBuilder result) {
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
