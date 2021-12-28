import java.util.ArrayList;

public class Line {
    String SIDE_RAIL = "|";
    String RUNG = "-";
    String SPACE = " ";
    private final ArrayList<Boolean> line;

    Line(ArrayList<Boolean> line) {
        this.line = line;
    }

    /**
     * 한 줄을 출력하는 메서드
     */
    public void printLine() {
        System.out.printf("%s", SIDE_RAIL);

        for (Boolean aBoolean : line) {
            System.out.printf("%s", aBoolean ? RUNG : SPACE);
            System.out.printf("%s", SIDE_RAIL);
        }
    }
}