package rubam.step4.view;

import rubam.step4.domain.Ladder;
import rubam.step4.domain.Line;

import java.util.List;

public class LadderPrinter {

    private static final String INTERVAL = "  ";
    private static final String HORIZONTAL_STEP = "-----";
    private static final String VERTICAL_STEP = "|";
    private static final String BLANK_STEP = "     ";
    private static final String BLANK = " ";
    private static final int MAX_LENGTH = 5;

    private LadderPrinter() {

    }

    public static void printLadder(Ladder ladder) {
        printNames(ladder.getNamesData());
        List<Line> ladderData = ladder.getLinesData();
        for (Line line : ladderData) {
            printLine(line);
        }
    }

    private static void printNames(List<String> names) {
        for (String name : names) {
            printSingleName(name);
        }
        System.out.println();
    }

    private static void printSingleName(String name) {
        int blankCount = (MAX_LENGTH - name.length()) / 2;
        int prefixBlankCount = blankCount + ((MAX_LENGTH - name.length()) % 2);
        int suffixBlankCount = blankCount;

        printBlank(prefixBlankCount);
        System.out.print(name);
        printBlank(suffixBlankCount);
        System.out.print(BLANK);
    }

    private static void printBlank(int num) {
        for (int i = 0; i < num; i++)
            System.out.print(BLANK);
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder(INTERVAL + VERTICAL_STEP);
        for (Boolean b : line.getStepsData()) {
            sb.append(lineLocationCheck(b));
            sb.append(VERTICAL_STEP);
        }
        System.out.println(sb);
    }

    private static String lineLocationCheck(Boolean current) {
        if (current)
            return HORIZONTAL_STEP;
        return BLANK_STEP;
    }
}
