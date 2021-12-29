package view;

import domain.Ladder;
import domain.LadderLine;
import domain.LadderLinePiece;

public class OutputView {
    public static void printLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadder()) {
            printLadderLine(ladderLine);
            System.out.println();
        }
    }

    public static void printLadderLine(LadderLine ladderLine) {
        for (LadderLinePiece piece : ladderLine.getLadderLinePieces()) {
            System.out.print(piece.getValue());
        }
    }
}
