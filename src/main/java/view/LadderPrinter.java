package view;

import domain.Ladder;
import domain.Row;

import java.util.List;
import java.util.stream.Collectors;

import static application.LadderGame.MAXIMUM_NAME_LENGTH;

public class LadderPrinter {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-";
    private static final String EMPTY = " ";

    public static void drawLadder(List<String> names, Ladder ladder, List<String> results) {
        drawStringList(names);
        System.out.print(ladder.getRows()
                .stream()
                .map(LadderPrinter::makeRow)
                .collect(Collectors.joining(""))
        );
        drawStringList(results);
    }

    private static void drawStringList(List<String> list) {
        System.out.println(list.stream()
                .map(e -> String.format("%" + (MAXIMUM_NAME_LENGTH + 1) + "s", e))
                .collect(Collectors.joining("")));
    }

    public static String makeRow(Row row) {
        return String.format("%" + MAXIMUM_NAME_LENGTH + "s", PILLAR)
                + row.getBridges().stream()
                .map(e -> (e ? BRIDGE : EMPTY).repeat(MAXIMUM_NAME_LENGTH))
                .collect(Collectors.joining(PILLAR))
                + PILLAR + "\n";
    }
}
