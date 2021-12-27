package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.LineDto;

public class OutputView {

    private OutputView() {
    }

    public static void printLadder(LadderDto ladderDto) {
        for (LineDto lineDto : ladderDto.getLineDtos()) {
            printLine(lineDto);
        }
    }

    private static void printLine(LineDto lineDto) {
        final StringBuilder stringBuilder = new StringBuilder("|");
        for (boolean point : lineDto.getPoints()) {
            stringBuilder.append(getSignature(point))
                .append("|");
        }
        System.out.println(stringBuilder);
    }

    private static String getSignature(boolean point) {
        if (point) {
            return "-";
        }
        return " ";
    }
}
