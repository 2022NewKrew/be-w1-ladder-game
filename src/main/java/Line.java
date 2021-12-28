import java.util.ArrayList;

public class Line {
    private final ArrayList<Boolean> line;

    Line(ArrayList<Boolean> line) {
        this.line = line;
    }

    /**
     * 한 줄을 출력하는 메서드
     */
    public void printLine() {
        String SIDE_RAIL = "|";
        System.out.printf("%s", SIDE_RAIL);

        for (Boolean aBoolean : line) {
            String RUNG = "-";
            String SPACE = " ";
            System.out.printf("%s", aBoolean ? RUNG : SPACE);
            System.out.printf("%s", SIDE_RAIL);
        }
    }
}