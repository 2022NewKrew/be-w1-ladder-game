package com.gunyoung.one.boot;

import com.gunyoung.one.ladder.Ladder;
import com.gunyoung.one.user.User;

public class ShapeMaker {
    private final Ladder ladder = Ladder.getInstance();

    String getShapeOfGameResult() {
        StringBuilder sb = new StringBuilder();

        getShapeOfLadder(sb);
        return sb.toString();
    }

    private void getShapeOfUsers(StringBuilder sb) {
        for(User user: ladder.getUsers()) {

        }
    }

    private void getShapeOfLadder(StringBuilder sb) {
        for (int row = 0; row < ladder.getLadderHeight(); row++) {
            getShapeOfLadderForEachRow(sb, row);
        }
    }

    private void getShapeOfLadderForEachRow(StringBuilder sb, int row) {
        sb.append("  |");
        char[] signaturesOfBridges = ladder.getBridge().getSignaturesOf(row);
        for (char signature : signaturesOfBridges) {
            sb.append(signature)
                    .append(signature)
                    .append(signature)
                    .append(signature)
                    .append(signature)
                    .append("|");
        }
        sb.append("\n");
    }
}
