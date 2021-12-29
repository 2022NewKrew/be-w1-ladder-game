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
    private static final int ALLOWED_SPACE = 7;
    public static final String EMPTY_SPACE = " ";

    public static void printLadderToConsole(Ladder ladder, List<String> userList) {
        printUserList(userList);
        for (LadderFrameLine ladderFrameLine : ladder.getLines()) {
            System.out.println(ladderLineToShapeLine(ladderFrameLine));
        }
    }

    private static String ladderLineToShapeLine(LadderFrameLine ladderFrameLine) {
        StringJoiner stringJoiner = new StringJoiner(PILLAR, LEFT_PILLAR, RIGHT_PILLAR);
        for (LadderFrame ladderFrame : ladderFrameLine.getFrames()) {
            stringJoiner.add(ladderFrameToShape(ladderFrame));
        }
        return stringJoiner.toString();
    }

    private static String ladderFrameToShape(LadderFrame ladderFrame) {
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
        double temp = (ALLOWED_SPACE - userName.length());
        int leftSpace = (int) Math.ceil(temp / 2);
        int rightSpace = (int) (temp - leftSpace) - 1;
        System.out.print(EMPTY_SPACE.repeat(leftSpace) + userName + EMPTY_SPACE.repeat(rightSpace));
    }

}
