package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawLadder {
    private static final int nameLength = 5;

    public static String drawLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append(formatNames(ladder.getPeopleNames()));
        for (Line line: ladder.getLines()) {
            sb.append(printLine(line));
        }
        return sb.toString();
    }

    private static String printLine(Line line) {
        ArrayList<Boolean> points = line.getPoints();
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        for (Boolean e : points) {
            sb.append(e ? " ".repeat(nameLength) + "|" : "-".repeat(nameLength) + "|");
        }
        sb.append('\n');
        return sb.toString();
    }

    @Test
    void testPrintLine() {
        Line line = new Line(new ArrayList<>(Arrays.asList(true, true, false, false, false)));
        assertEquals(printLine(line), "  |     |     |-----|-----|-----|\n");
    }

    private static String formatName(String name) {
        StringBuilder sb = new StringBuilder();
        int spaceLength = nameLength + 1 - name.length();
        sb.append(" ".repeat(Math.max(0, spaceLength / 2)));
        sb.append(name);
        sb.append(" ".repeat(Math.max(0, spaceLength - spaceLength / 2)));
        return sb.toString();
    }

    @Test
    void testFormatName() {
        assertEquals("hello ", formatName("hello"));
        assertEquals(" hell ", formatName("hell"));
        assertEquals(" hel  ", formatName("hel"));
        assertEquals("  he  ", formatName("he"));
        assertEquals("  h   ", formatName("h"));
    }

    private static String formatNames(List<String> peopleNames) {
        StringBuilder sb = new StringBuilder();
        for(String name: peopleNames) {
            sb.append(formatName(name));
        }
        sb.append('\n');
        return sb.toString();
    }

    @Test
    void testFormatNames() {
        assertEquals(formatNames(Arrays.asList("hello", "hell", "hel", "he", "h")), "hello " + " hell " + " hel  " + "  he  " + "  h   " + '\n');
    }
}
