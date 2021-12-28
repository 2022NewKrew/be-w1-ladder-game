import java.util.ArrayList;

public class Ladder {
    private final ArrayList<Line> lines;

    Ladder(ArrayList<Line> lines) {
        this.lines = lines;
    }

    /**
     * 사다리를 화면에 출력하는 메서드
     */
    void printLadder() {
        for (Line line : lines) {
            line.printLine();
            System.out.println();
        }
    }
}
