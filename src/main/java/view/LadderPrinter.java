package view;

import domain.Ladder;
import domain.Row;

import java.util.stream.Collectors;

public class LadderPrinter {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-";
    private static final String EMPTY = " ";

    public static void drawLadder(Ladder ladder) {
        System.out.println(ladder.getRows()
                .stream()
                .map(LadderPrinter::makeRow)
                .collect(Collectors.joining(""))
        );
    }

    public static String makeRow(Row row) {
        return PILLAR + row.getBridges().stream()
                .map(e -> e ? BRIDGE : EMPTY)
                .collect(Collectors.joining(PILLAR))
                + PILLAR + "\n";
    }
}
