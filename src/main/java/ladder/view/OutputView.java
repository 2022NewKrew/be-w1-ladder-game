package ladder.view;

import java.util.ArrayList;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;

public class OutputView {

    private static final String NOT_EXIST_BRIDGE = "     ";
    private static final String EXIST_BRIDGE = "-----";
    private static final String LADDER_STICK = "|";

    public OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            sb.append(printLine(line)).append("\n");
        }
        System.out.println(sb);
    }

    private static String printLine(Line line) {
        StringBuilder sb = new StringBuilder("  ").append(LADDER_STICK);
        for (Boolean bridge : line.getBridges()) {
            sb.append(printBridge(bridge)).append(LADDER_STICK);
        }
        return sb.toString();
    }

    private static String printBridge(Boolean bridge) {
        return bridge ? EXIST_BRIDGE : NOT_EXIST_BRIDGE;
    }

    public static void printPerson(ArrayList<Person> persons) {
        StringBuilder sb = new StringBuilder();
        for (Person person : persons) {
            String name = person.getName();
            int totalSpaceNum = 5 - name.length();
            int leftSpaceNum = totalSpaceNum / 2;
            int rightSpaceNum = totalSpaceNum - leftSpaceNum;

            sb.append(makeSpace(leftSpaceNum)).append(name).append(makeSpace(rightSpaceNum))
                .append(" ");
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