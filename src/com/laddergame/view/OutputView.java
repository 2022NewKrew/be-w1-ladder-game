package com.laddergame.view;

import java.util.List;

public class OutputView {
    private OutputView() throws RuntimeException {
        throw new RuntimeException("Unnecessary instance generation");
    }

    private enum DELIMITER {
        LADDER("-----"),
        NO_LADDER("     "),
        VERTICAL_LINE("|"),
        LADDER_PADDING("    ")
        ;

        DELIMITER(String delimiter) {
            this.value = delimiter;
        }

        private final String value;
    }

    public static void outputLadderGameResult(List<List<Boolean>> result, List<String> names) {
        System.out.println("사다리 결과\n");
        outputParticipantNames(names);
        result.forEach(OutputView::outputLineResult);
    }

    public static void outputParticipantResult(String result) {
        System.out.println(result);
    }

    private static void outputParticipantNames(List<String> names) {
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    private static void outputLineResult(List<Boolean> lineResult) {
        System.out.print(DELIMITER.LADDER_PADDING.value);
        lineResult.forEach(hasLadder -> {
            System.out.print(DELIMITER.VERTICAL_LINE.value);
            String ladder = hasLadder ? DELIMITER.LADDER.value : DELIMITER.NO_LADDER.value;
            System.out.print(ladder);
        });
        System.out.println(DELIMITER.VERTICAL_LINE.value);
    }
}
