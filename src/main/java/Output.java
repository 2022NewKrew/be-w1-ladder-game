import java.util.ArrayList;

public class Output {
    static final String SIDE_RAIL = "|";
    static final String RUNG = "-----";
    static final String SPACE = "     ";

    /**
     * 사다리의 한 줄을 출력하는 메서드
     * @param line 출력할 한 줄
     */
    static public void printLine(ArrayList<Boolean> line) {
        System.out.printf("%s%s", SPACE, SIDE_RAIL);

        for (Boolean aBoolean : line) {
            System.out.printf("%s", aBoolean ? RUNG : SPACE);
            System.out.printf("%s", SIDE_RAIL);
        }
    }

    /**
     * 사다리를 출력하는 메서드
     * @param lines 출력할 줄 리스트
     */
    static void printLadder(ArrayList<Line> lines) {
        for (Line line : lines) {
            printLine(line.getLine());
            System.out.println();
        }
    }

    /**
     * 이름 사이의 공백을 출력하는 메서드
     * @param beforeName 공백 이전 이름
     * @param afterName 공백 이후 이름
     */
    static void printSpaceBetweenNames(String beforeName, String afterName) {
        int beforeNameLength = beforeName.length() == 0 ? 0 : (beforeName.length() + 1) / 2 - 1;
        int afterNameLength = afterName.length() / 2;
        int spaceCount = SPACE.length() - beforeNameLength - afterNameLength;

        for (int i = 0;  i < spaceCount; i++)
            System.out.print(" ");
    }

    /**
     * 사다리타기의 맨 윗줄 이름을 출력하는 메서드
     * @param names 출력할 이름 리스트
     */
    static void printName(ArrayList<String> names) {
        printSpaceBetweenNames("", names.get(0));
        System.out.printf("%s", names.get(0));
        for (int i = 1; i < names.size(); i++) {
            printSpaceBetweenNames(names.get(i - 1), names.get(i));
            System.out.printf("%s", names.get(i));
        }
        System.out.println();
    }
}
