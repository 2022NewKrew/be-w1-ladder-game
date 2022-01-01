package view;

import domain.*;

public class OutputView {

    public static void printPlayers(PlayerRepository playerRepository) {
        for (Player player : playerRepository.getPlayers()) {
            printPlayer(player);
        }
        System.out.println();
    }

    public static void printPlayer(Player player) {
        System.out.print(player.getName());
    }

    public static void printLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadder()) {
            printLadderLine(ladderLine);
            System.out.println();
        }
    }

    public static void printLadderLine(LadderLine ladderLine) {
        for (Piece piece : ladderLine.getLadderLinePieces()) {
            System.out.print(piece.getValue());
        }
    }
}
