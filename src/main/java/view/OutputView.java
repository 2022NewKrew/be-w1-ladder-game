package view;

import domain.*;

public class OutputView {
    private static final int PIECE_REPEAT_NUM = 5;
    private static final String PIECE_ROW = "-".repeat(PIECE_REPEAT_NUM);
    private static final String PIECE_SPACE = " ".repeat(PIECE_REPEAT_NUM);

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
        System.out.println("현재 output문");
        System.out.println(ladder);
        System.out.println(ladder.getLadder());

        for (LadderLine ladderLine : ladder.getLadder()) {
            printLadderLine(ladderLine);
            System.out.println();
        }
    }

    public static void printLadderLine(LadderLine ladderLine) {
        System.out.println("현재 line output");
        System.out.println(ladderLine);
        System.out.println(ladderLine.getLadderLinePieces());

        for (Piece piece : ladderLine.getLadderLinePieces()) {
            System.out.print(piece.getPiece());
        }
    }
}
