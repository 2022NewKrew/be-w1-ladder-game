package Ladder.IOManager;

import Ladder.DTO.outputLineDTO;
import Ladder.HorizBarLine;

public class OutputManager {
    private static final char VER_BAR = '|';

    public static void printLine(outputLineDTO line) {
        HorizBarLine printLine = line.getLine();

        for (char cell : printLine.getLine()) {
            System.out.print(VER_BAR);
            System.out.print(cell);
        }
        System.out.println(VER_BAR);
    }
}
