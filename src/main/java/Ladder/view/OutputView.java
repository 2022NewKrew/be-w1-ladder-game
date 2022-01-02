package Ladder.view;

import Ladder.DTO.outputLineDTO;

import java.util.List;

public class OutputView {
    private OutputView() {}

    public static void printLine(outputLineDTO line) {
        List<String> printLine = line.getLine();

        for (String str : printLine) {
            System.out.print(str);
        }
        System.out.println("");
    }
}
