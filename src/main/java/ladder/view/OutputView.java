package ladder.view;

import ladder.domain.Ladder;

public class OutputView {

    public OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (boolean[] branch : ladder.getIsBranch()) {
            sb.append(printLine(branch)).append("\n");
        }
        System.out.println(sb);
    }

    private static String printLine(boolean[] branch) {
        StringBuilder sb = new StringBuilder("|");
        for (boolean oneBranch : branch) {
            sb.append(existBranch(oneBranch)).append("|");
        }
        return sb.toString();
    }

    private static String existBranch(boolean oneBranch) {
        return oneBranch ? "-" : " ";
    }
}
