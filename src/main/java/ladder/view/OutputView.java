package ladder.view;

import ladder.domain.Line;
import ladder.dto.OutputDTO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static ladder.domain.LadderComponent.*;

public class OutputView {

    static BufferedWriter wr;

    public static void printLadderResult(OutputDTO outputComponent) throws IOException {
        wr = new BufferedWriter(new OutputStreamWriter(System.out));
        printNameOfPeople(outputComponent.getNamesOfPeople());
        for (Line curHorizon : outputComponent.getLadder()) {
            wr.append(LADDER_INTENT);
            printColLadder(curHorizon);
            wr.newLine();
        }
        wr.flush();
        wr.close();
    }

    private static void printNameOfPeople(String[] namesOfPeople) throws IOException {
        for (String name : namesOfPeople) {
            wr.append(String.format("%" + MAX_NAME_LENGTH + "s", name) + " ");
        }
        wr.newLine();
    }

    private static void printColLadder(Line curHorizon) throws IOException {
        for (Boolean isLink : curHorizon.getIsLinkLists()) {
            wr.append(VERTICAL_LADDER);
            wr.append(isLink ? HORIZON_LADDER : BLANK);
        }
        wr.append(VERTICAL_LADDER);
    }
}
