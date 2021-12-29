package view;

import domain.ladder.Ladder;
import domain.ladder.LadderFrame;
import domain.ladder.LadderFrameLine;

import java.util.List;
import java.util.StringJoiner;

public class UserOutput {

    private static final String BRIDGE_SHAPE = "-----";
    private static final String SPACE_SHAPE = "     ";
    private static final String LEFT_PILLAR = "   |";
    private static final String PILLAR = "|";
    private static final String RIGHT_PILLAR = "|  ";

    public static void printLadderToConsole(Ladder ladder, List<String> userList) {
        printUserList(userList);
        for (LadderFrameLine ladderFrameLine : ladder.getLadderFrameLineList()) {
            System.out.println(LadderLineToShapeLine(ladderFrameLine));
        }
    }

    private static String LadderLineToShapeLine(LadderFrameLine ladderFrameLine) {
        StringJoiner stringJoiner = new StringJoiner(PILLAR, LEFT_PILLAR, RIGHT_PILLAR);
        for (LadderFrame ladderFrame : ladderFrameLine.getLadderFrameList()) {
            stringJoiner.add(LadderFrameToShape(ladderFrame));
        }
        return stringJoiner.toString();
    }

    private static String LadderFrameToShape(LadderFrame ladderFrame) {
        if (ladderFrame.equals(LadderFrame.BRIDGE)) {
            return BRIDGE_SHAPE;
        }
        return SPACE_SHAPE;
    }

    private static void printUserList(List<String> userList) {
        for (String userName : userList) {
            formattedPrintForUser(userName);
        }
        System.out.println();
    }
    private static void formattedPrintForUser(String userName) {
        int leftSpace;
        int rightSpace;
        double temp;
        temp = (7 - userName.length());
        leftSpace = (int) Math.ceil(temp / 2);
        rightSpace = ((int) temp - leftSpace) - 1;
        System.out.print(" ".repeat(leftSpace) + userName + " ".repeat(rightSpace));
    }

}
