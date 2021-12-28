import java.util.ArrayList;

public class Output {
    static final String SIDE_RAIL = "|";
    static final String RUNG = "-";
    static final String SPACE = " ";

    /**
     * 한 줄을 출력하는 메서드
     */
    static public void printLine(ArrayList<Boolean> line) {
        System.out.printf("%s", SIDE_RAIL);

        for (Boolean aBoolean : line) {
            System.out.printf("%s", aBoolean ? RUNG : SPACE);
            System.out.printf("%s", SIDE_RAIL);
        }
    }

    /**
     * 사다리를 화면에 출력하는 메서드
     */
    static void printLadder(ArrayList<String> names, ArrayList<Line> lines) {
        for (String name: names) {
            System.out.printf("%s\t ", name);
        }
        System.out.println();

        for (Line line : lines) {
            printLine(line.getLine());
            System.out.println();
        }
    }
}
