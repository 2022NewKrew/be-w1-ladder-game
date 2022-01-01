package view;

import domain.*;

public class OutputView {
    private static final int PIECE_REPEAT_NUM = 5;
    private static final String PIECE_HORIZONTAL = "|";
    private static final String PIECE_ROW = "-".repeat(PIECE_REPEAT_NUM);
    private static final String PIECE_SPACE = " ".repeat(PIECE_REPEAT_NUM);

    public static void printPlayers(PlayerRepository playerRepository) {
        for (Player player : playerRepository.getPlayers()) {
            printPlayer(player);
        }
        System.out.println();
    }

    public static void printPlayer(Player player) {
        System.out.print(String.format("%6s", player.getName()));
    }

    public static void printLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadder()) {
            printLadderLine(ladderLine);
            System.out.println();
        }
    }

    public static void printLadderLine(LadderLine ladderLine) {
        System.out.print(PIECE_SPACE);
        for (Piece piece : ladderLine.getLadderLinePieces()) {
            System.out.print(PIECE_HORIZONTAL);
            String temp = (piece.getPiece()) ? PIECE_ROW : PIECE_SPACE;
            System.out.print(temp);
        }
        System.out.print(PIECE_HORIZONTAL);
    }
}
