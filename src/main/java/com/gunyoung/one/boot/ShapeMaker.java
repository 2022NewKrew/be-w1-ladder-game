package com.gunyoung.one.boot;

import com.gunyoung.one.ladder.Ladder;
import com.gunyoung.one.user.User;

public class ShapeMaker {

    private static final int BRIDGE_SIZE = 5;
    private static final int BLANK_NUM_BEFORE_EACH_ROW = 2;
    private static final String COLUMN_SHAPE = "|";
    private static final String BRIDGE_SHAPE = "-";
    private static final String BLANK = " ";

    private final Ladder ladder = Ladder.getInstance();

    String getShapeOfGameResult() {
        StringBuilder sb = new StringBuilder();
        getShapeOfUsers(sb);
        getShapeOfLadder(sb);
        return sb.toString();
    }

    private void getShapeOfUsers(StringBuilder sb) {
        for(User user: ladder.getUsers()) {
            String userNameWithBlank = getUserNameWithBlank(user);
            sb.append(userNameWithBlank);
        }
    }

    private String getUserNameWithBlank(User user) {
        StringBuilder sb = new StringBuilder();
        String userName = user.getName();
        getBlanksBeforeName(sb, userName);
        sb.append(userName);
        sb.append(BLANK);
        return sb.toString();
    }

    private void getBlanksBeforeName(StringBuilder sb, String userName) {
        int numOfBlankBeforeName = getNumOfBlankBeforeName(userName);
        sb.append(
                getBlankWithRepeat(Math.max(0, getNumOfBlankBeforeName(userName)))
        );
    }

    private int getNumOfBlankBeforeName(String userName) {
        if(userName.length() <= 2) {
            return 2;
        }
        if(userName.length() <= 3) {
            return 1;
        }
        return 0;
    }

    private String getBlankWithRepeat(int repeatCount) {
        return BLANK.repeat(repeatCount);
    }

    private void getShapeOfLadder(StringBuilder sb) {
        for (int row = 0; row < ladder.getLadderHeight(); row++) {
            getShapeOfLadderForEachRow(sb, row);
        }
    }

    private void getShapeOfLadderForEachRow(StringBuilder sb, int row) {
        getBlanksBeforeRowStart(sb);
        sb.append(COLUMN_SHAPE);
        char[] signaturesOfBridges = ladder.getBridge().getSignaturesOf(row);
        for (char signature : signaturesOfBridges) {
            sb.append(
                    String.valueOf(signature).repeat(BRIDGE_SIZE)
            ).append(COLUMN_SHAPE);
        }
        sb.append("\n");
    }

    private void getBlanksBeforeRowStart(StringBuilder sb) {
        sb.append(
                getBlankWithRepeat(BLANK_NUM_BEFORE_EACH_ROW)
        );
    }
}
