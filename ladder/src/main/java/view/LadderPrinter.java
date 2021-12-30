package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class LadderPrinter {
    public void print(Ladder ladder){
        printParticipants(ladder.getLines());
        printLadder(ladder);
        printResults(ladder.getLines());
    }

    private void printLadder(Ladder ladder){
        for (int currentHeight = 0; currentHeight < ladder.getLadderHeight(); currentHeight++)
            printRow(ladder, currentHeight);
    }

    private void printRow(Ladder ladder, int curHeight){
        System.out.print("   ");
        ladder.getLines().stream()
            .map(line -> mapBar(line, curHeight))
            .forEach(System.out::print);
        System.out.println();
    }

    private String mapBar(Line line, int curHeight){
        if (line.getConnections()[curHeight] != null
                && line.getLineNum() < line.getConnections()[curHeight].getLineNum())
            return "|-----";
        return "|     ";
    }

    private void printParticipants(List<Line> lines){
        lines.stream()
                .map(line -> line.getParticipant().getName())
                .forEach(name -> StringAlignManager.alignCenter(5, 1, name));
        System.out.println();
    }

    private void printResults(List<Line> lines){
        lines.stream()
                .map(line -> line.getResult().getName())
                .forEach(result -> StringAlignManager.alignCenter(5, 1, result));
        System.out.println();
    }
}
