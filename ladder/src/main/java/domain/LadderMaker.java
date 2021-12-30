package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    private static final Random random = new Random();

    public static List<Line> build(List<Participant> participants, List<Result> results, int maxHeight){
        List<Line> lines = new ArrayList<>();
        // Line 생성 (no connections)
        for (int lineNum = 0; lineNum < participants.size(); lineNum++)
            lines.add(new Line(lineNum, maxHeight, participants.get(lineNum), results.get(lineNum)));

        // 생성한 Line 에 connection 생성
        buildConnections(lines, maxHeight);

        return lines;
    }

    private static void buildConnections(List<Line> lines, int maxHeight){
        for(int lineIndex = 0; lineIndex < lines.size() - 1; lineIndex++) {
            Line curLine = lines.get(lineIndex);
            Line nextLine = lines.get(lineIndex + 1);
            buildConnectionBetweenTwoLines(curLine, nextLine, maxHeight);
        }
    }

    private static void buildConnectionBetweenTwoLines(Line curLine, Line nextLine, int maxHeight){
        for (int curHeight = 0; curHeight < maxHeight; curHeight++) {
            connectIfValid(curLine, nextLine, curHeight);
        }
    }

    private static void connectIfValid(Line curLine, Line nextLine, int curHeight){
        if (!curLine.checkConnected(curHeight) && random.nextBoolean())
            curLine.setConnection(nextLine, curHeight);
    }
}
