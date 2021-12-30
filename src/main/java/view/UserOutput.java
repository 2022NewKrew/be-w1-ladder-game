package view;

import domain.ladder.LadderFrame;
import domain.ladder.LadderFrameLine;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;
import dto.ladderDto.LadderDTO;


import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class UserOutput {

    private static final String EMPTY_SPACE = " ";
    private static final String BRIDGE = "-";
    private static final String PILLAR = "|";
    private static final String BRIDGE_SHAPE = BRIDGE.repeat(5);
    private static final String SPACE_SHAPE = EMPTY_SPACE.repeat(5);
    private static final String LEFT_PILLAR = EMPTY_SPACE.repeat(3) + PILLAR;
    private static final String RIGHT_PILLAR = PILLAR;
    private static final int ALLOWED_SPACE = 7;

    public static void printLadderToConsole(LadderDTO ladder, List<String> userList, List<String> results) {
        printUserList(userList);
        for (LadderFrameLine ladderFrameLine : ladder.getLines()) {
            System.out.println(ladderLineToShapeLine(ladderFrameLine));
        }
    }

    public static void printTargetResult(TargetResultDTO result) {
        System.out.println(result.getResult());
    }

    public static void printAllResult(AllResultDTO results) {
        for (Map.Entry<String, String> result : results.getResults()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
    }

    private static String ladderLineToShapeLine(LadderFrameLine ladderFrameLine) {
        StringJoiner stringJoiner = new StringJoiner(PILLAR, LEFT_PILLAR, RIGHT_PILLAR);
        for (LadderFrame frame : ladderFrameLine.getFrames()) {
            stringJoiner.add(ladderFrameToShape(frame));
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
            formattedPrint(userName);
        }
        System.out.println();
    }

    private static void formattedPrint(String userName) {
        double temp = (ALLOWED_SPACE - userName.length());
        int leftSpace = (int) Math.ceil(temp / 2);
        int rightSpace = (int) (temp - leftSpace) - 1;
        System.out.print(EMPTY_SPACE.repeat(leftSpace) + userName + EMPTY_SPACE.repeat(rightSpace));
    }
}
