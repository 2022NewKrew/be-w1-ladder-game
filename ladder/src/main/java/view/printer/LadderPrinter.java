package view.printer;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class LadderPrinter {
    public void print(Ladder ladder){
        printParticipants(ladder.getLines());
        printLadder(ladder);
        printResults(ladder.getLines());
    }

    private void printLadder(Ladder ladder) {
        System.out.println(ladder.getShape());
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
