package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.Constants;
import bin.jayden.ladder_game.domain.Ladder;
import bin.jayden.ladder_game.domain.LadderInfo;
import bin.jayden.ladder_game.domain.LadderRow;

import java.util.List;

public class LadderGamePrinter {
    private LadderGamePrinter() {
        //instance 생성 제한용 생성자
    }

    public static void printGame(Ladder ladder, LadderInfo info) {
        printParticipants(info.getParticipants());
        printLadder(ladder);
    }

    private static void printParticipants(List<String> participants) {
        participants.forEach(participant -> System.out.printf("%" + Constants.MAX_NAME_SIZE + "s ", participant));
    }

    private static void printLadder(Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (LadderRow row : ladderRows) {
            System.out.printf("\n%" + Constants.PREFIX_SIZE + "s", "|");
            row.getRow().forEach(LadderGamePrinter::printLine);
        }
    }

    private static void printLine(boolean isLine) {
        char ladderCharacter = isLine ? Constants.LADDER_LINE_CHARACTER : Constants.LADDER_EMPTY_CHARACTER;
        for (int i = 0; i < Constants.MAX_NAME_SIZE; i++)
            System.out.print(ladderCharacter);
        System.out.print(Constants.LADDER_SEPARATION_CHARACTER);
    }
}
