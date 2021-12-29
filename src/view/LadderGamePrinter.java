package view;

import data.Ladder;
import data.LadderInfo;
import data.LadderRow;

import java.util.List;

public class LadderGamePrinter {
    private LadderGamePrinter() {
        //instance 생성 제한용 생성자
    }

    public static void printGame(Ladder ladder, LadderInfo info) {
        printParticipants(info);
        printLadder(ladder);
    }

    private static void printParticipants(LadderInfo info) {
        info.getParticipants()
                .forEach(participant -> System.out.printf("%5s ", participant));
    }

    private static void printLadder(Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (LadderRow row : ladderRows) {
            System.out.print("\n   |");
            row.getRow().forEach(it -> System.out.print(it ? "-----|" : "     |"));
        }
    }
}
