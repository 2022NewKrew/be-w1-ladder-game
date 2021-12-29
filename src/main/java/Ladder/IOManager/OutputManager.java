package Ladder.IOManager;

import Ladder.DTO.outputLineDTO;

import java.util.List;

public class OutputManager {
    private static final char VER_BAR = '|';
    private static final char BLANK = ' ';

    public static void printLine(outputLineDTO line) {
        List<String> printLine = line.getLine();

        for (String cell : printLine) {
            System.out.print(VER_BAR);
            System.out.print(cell);
        }
        System.out.println(VER_BAR);
    }

    public static void printNameLine(outputLineDTO line) {
        List<String> printLine = line.getLine();

        for (String name : printLine) {
            System.out.print(name);
            System.out.print(BLANK);
        }
        System.out.println();
    }
}
