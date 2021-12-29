package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;

import java.util.List;

public class OutputView {

    private static final String STICK = "|";
    private static final String EXISTED_BRIDGE = "-----";
    private static final String NOT_EXISTED_BRIDGE = "     ";
    private static final int MAX_LENGTH_OF_NAME = 5;

    public static void outputLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            outputLine(line);
            System.out.println();
        }
    }

    private static void outputLine(Line line) {
        System.out.print("  ");
        System.out.print(STICK);
        for (boolean bridge : line.getBridges()) {
            String outputBridge = bridge ? EXISTED_BRIDGE : NOT_EXISTED_BRIDGE;
            System.out.print(outputBridge);
            System.out.print(STICK);
        }
    }

    public static void outputPerson(List<Person> people) {
        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            String name = person.getName();
            int totalSpaceNum = MAX_LENGTH_OF_NAME - name.length();
            int leftSpaceNum = totalSpaceNum / 2;
            int rightSpaceNum = totalSpaceNum - leftSpaceNum;
            sb.append(makeSpace(leftSpaceNum)).append(name).append(makeSpace(rightSpaceNum)).append(" ");
        }
        System.out.println(sb);
    }

    private static String makeSpace(int spaceNum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaceNum; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
