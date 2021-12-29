package view;

import domain.LadderGenerator;
import domain.LineGenerator;

public class OutputView {
    public static void printLadder(LadderGenerator ladderGenerator) {
        for (int i = 0; i < ladderGenerator.getLadder().size(); i++) {
            printLine(ladderGenerator.getLineGenerator(i));
            System.out.println();
        }
    }

    public static void printLine(LineGenerator lineGenerator) {
        for (String i : lineGenerator.getLine()) {
            System.out.print(i);
        }
    }
}