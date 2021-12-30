package Ladder.view;

import Ladder.DTO.outputLineDTO;

import java.util.List;

public class OutputView {
    private static final String VER_BAR = "|";
    private static final String BLANK = " ";
    private static final String PADDING = "  ";
    private static final int NAME_LEN = 5;

    public static void printLine(outputLineDTO line) {
        List<String> printLine = line.getLine();

        System.out.print(PADDING);
        for (String cell : printLine) {
            System.out.print(VER_BAR);
            System.out.print(cell);
        }
        System.out.print(VER_BAR);
        System.out.println(PADDING);
    }

    public static void printNameLine(outputLineDTO line) {
        List<String> printLine = line.getLine();

        for (String name : printLine) {
            String alignedName = centAlign(name, NAME_LEN);
            System.out.print(alignedName);
            System.out.print(BLANK);
        }
        System.out.println();
    }

    public static String centAlign(String str, int len) {
        if (str.length() >= len) {
            return str;
        }

        String retStr = "";
        retStr += " ".repeat((len - str.length()) / 2);
        retStr += str;
        retStr += " ".repeat((len - str.length() + 1) / 2);

        return retStr;
    }
}
