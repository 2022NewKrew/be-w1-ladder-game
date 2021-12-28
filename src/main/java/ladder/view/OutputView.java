package ladder.view;

import ladder.domain.Ladder;

public class OutputView {

    public static void outputLadder(Ladder ladder){
        char[][] lines = ladder.getLines();
        for (char[] line : lines) {
            outputLine(line);
            System.out.println();
        }
    }

    private static void outputLine(char[] line){
        for(char bridge : line) {
            System.out.print(bridge);
        }
    }
}
