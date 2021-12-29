package view;

import domain.ladder.Ladder;
import domain.ladder.LadderFrame;
import domain.ladder.LadderFrameLine;

import java.util.StringJoiner;

public class UserOutput {

    private static final String BRIDGE_SHAPE = "-";
    private static final String SPACE_SHAPE = " ";
    private static final String PILLAR = "|";

    public static void printLadderToConsole(Ladder ladder) {
        for (LadderFrameLine ladderFrameLine : ladder.getLadderFrameLineList()) {
            System.out.println(LadderLineToShapeLine(ladderFrameLine));
        }
    }

    private static String LadderLineToShapeLine(LadderFrameLine ladderFrameLine) {
        StringJoiner stringJoiner = new StringJoiner(PILLAR, PILLAR, PILLAR);
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

}
