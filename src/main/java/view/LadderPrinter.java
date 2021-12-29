package view;

import domain.Ladder;
import domain.Row;

import java.util.List;
import java.util.stream.Collectors;

public class LadderPrinter {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-";
    private static final String EMPTY = " ";
    public static final int maximumNameLength = 15;

    public static void drawLadder(List<String> names, Ladder ladder) {
        System.out.println(names.stream()
                .map(e -> String.format("%" + (maximumNameLength + 1) + "s", e))
                .collect(Collectors.joining("")));
        System.out.println(ladder.getRows()
                .stream()
                .map(LadderPrinter::makeRow)
                .collect(Collectors.joining(""))
        );
    }

    public static String makeRow(Row row) {
        return String.format("%" + maximumNameLength + "s", PILLAR)
                + row.getBridges().stream()
                .map(e -> (e ? BRIDGE : EMPTY).repeat(maximumNameLength))
                .collect(Collectors.joining(PILLAR))
                + PILLAR + "\n";
    }
}
