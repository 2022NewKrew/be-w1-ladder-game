package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.Constants;
import bin.jayden.ladder_game.domain.Ladder;
import bin.jayden.ladder_game.domain.LadderGameInfo;
import bin.jayden.ladder_game.domain.LadderRow;

import java.util.List;

public class LadderGamePrinter {

    private LadderGamePrinter() {

    }

    private static void printLine(boolean isLine) {
        char ladderCharacter = isLine ? Constants.LADDER_LINE_CHARACTER : Constants.LADDER_EMPTY_CHARACTER;
        for (int i = 0; i < Constants.MAX_NAME_SIZE; i++) {
            System.out.print(ladderCharacter);
        }
        System.out.print(Constants.LADDER_SEPARATION_CHARACTER);
    }

    public static void printGame(LadderGameInfo info, Ladder ladder) {
        System.out.print(listToFormattedString(info.getParticipants()));
        printLadder(ladder);
        System.out.println("\n" + listToFormattedString(info.getResults()));
    }

    public static void printResult(String result) {
        if (result != null)
            System.out.println(result);

    }


    private static String listToFormattedString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(element -> stringBuilder.append(String.format("%" + Constants.MAX_NAME_SIZE + "s ", element)));
        return stringBuilder.toString();
    }

    private static void printLadder(Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (LadderRow row : ladderRows) {
            System.out.printf("\n%" + Constants.PREFIX_SIZE + "s", "|");
            row.getRow().forEach(LadderGamePrinter::printLine);
        }
    }
}
