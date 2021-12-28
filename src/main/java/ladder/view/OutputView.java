package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.ArrayList;

public class OutputView {

    public static void outputLadder(Ladder ladder){
        ArrayList<Line> lines = ladder.getLines();
        for (Line line : lines) {
            outputLine(line);
            System.out.println();
        }
    }

    private static void outputLine(Line line){
        for(String bridge : line.getBridges()) {
            System.out.print(bridge);
        }
    }
}
