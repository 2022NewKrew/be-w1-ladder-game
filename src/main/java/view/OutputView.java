package view;

import domain.Ladder;
import domain.LadderLine;
import domain.LadderLinePiece;
import domain.Player;

import java.util.List;

public class OutputView {
    public static void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.print(player.getName());
        }
        System.out.println();
    }

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
