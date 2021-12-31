package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class StandardOutLadderGameRenderer implements LadderGameRenderer {
    private final String STRIPE = "|";
    private final String BRIDGE = "-----";
    private final String SPACE = "     ";

    @Override
    public void displayGameSettings(List<String> participants, Ladder ladder, List<String> results) {
        StringBuilder sb = new StringBuilder();

        sb.append(stringListToString(participants)).append(System.lineSeparator())
                .append(ladderToString(ladder))
                .append(stringListToString(results));

        System.out.println(sb);
    }

    @Override
    public void displaySentence(String sentence) {
        System.out.println(sentence);
    }

    private String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        stringList.forEach(string -> sb.append(String.format("%-6s", string)));

        return sb.toString();
    }

    private String ladderToString(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        List<Line> listTypeLadder = ladder.getLadderToList();

        listTypeLadder.forEach(line -> sb.append(lineToString(line)).append(System.lineSeparator()));

        return sb.toString();
    }

    private String lineToString(Line line) {
        StringBuilder sb = new StringBuilder();
        List<Boolean> listTypeLine = line.getLineToList();
        sb.append(STRIPE);
        listTypeLine.forEach(e -> {
            sb.append(e ? BRIDGE : SPACE);
            sb.append(STRIPE);
        });

        return sb.toString();
    }
}
