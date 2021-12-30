package keith;

import java.util.Scanner;
import keith.domain.Ladder;
import keith.io.*;

public class Main {
    public static void main(String[] args) {
        InputManager im = new InputManager();
        OutputManager om = new OutputManager();

        try (Scanner scanner = new Scanner(System.in)) {
            Ladder ladder = im.getLadderInput(scanner);
            om.printLadder(ladder);

            boolean condition = true;
            while(condition) {
                String input = im.getResultInput(scanner);
                condition = om.printResult(input, ladder);
            }
        }
    }
}
