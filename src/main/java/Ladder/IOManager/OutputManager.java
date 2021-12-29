package Ladder.IOManager;

import Ladder.DTO.outputLineDTO;
import Ladder.DTO.outputNameDTO;
import Ladder.HorizBarLine;
import Ladder.NameLine;

public class OutputManager {
    private static final char VER_BAR = '|';
    private static final char BLANK = ' ';

    public static void printLine(outputLineDTO line) {
        HorizBarLine printLine = line.getLine();

        for (char cell : printLine.getLine()) {
            System.out.print(VER_BAR);
            System.out.print(cell);
        }
        System.out.println(VER_BAR);
    }

    public static void printLine(outputNameDTO line) {
        NameLine printLine = line.getLine();

        for (String name : printLine.getNameArray()) {
            System.out.print(name);
            System.out.print(BLANK);
        }
        System.out.println();
    }
}
