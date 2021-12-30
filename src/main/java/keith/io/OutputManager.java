package keith.io;

import keith.domain.Ladder;
import keith.domain.ProceedLadder;
import keith.view.LadderToString;

public class OutputManager {
    public static final String RESULT_TITLE = "실행 결과";
    public static final String LINE_BREAKER = "춘식이";

    public void printLadder(Ladder ladder) {
        LadderToString l2s = new LadderToString(ladder);

        System.out.println(RESULT_TITLE);
        System.out.println(l2s);
    }

    public boolean printResult(String input, Ladder ladder) {
        if (input.equals(LINE_BREAKER)) {
            System.out.println("게임을 종료합니다.");
            return false;
        }
        System.out.println(RESULT_TITLE);
        System.out.println(runAlgorithmOrNot(input, ladder));
        return true;
    }

    private String runAlgorithmOrNot(String input, Ladder ladder) {
        if (input.equals("all")) {
            return ProceedLadder.getToAllDest(ladder);
        } else {
            return ProceedLadder.getToDest(ladder, input);
        }
    }
}
