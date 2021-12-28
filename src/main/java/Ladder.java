import java.util.ArrayList;

public class Ladder {
    String SIDE_RAIL = "|";
    String RUNG = "-";
    String SPACE = " ";

    int numberOfRung = 0;
    int heightOfLadder = 0;
    ArrayList<Boolean> lines;

    Ladder(int numberOfRung, int heightOfLadder, ArrayList<Boolean> lines) {
        this.numberOfRung = numberOfRung;
        this.heightOfLadder = heightOfLadder;
        this.lines = lines;
    }

    /**
     * 사다리의 한 줄을 만들어주는 메서드
     * @param heightIdx 현재 몇 번째 줄에 있는지 인자로 받는다
     * @return 사다리의 한 줄을 String으로 만들어서 반환한다
     */
    String makeLine(int heightIdx) {
        StringBuilder line = new StringBuilder(SIDE_RAIL);

        for (int i = 0; i < numberOfRung; i++) {
            line.append(lines.get(numberOfRung * heightIdx + i) ? RUNG : SPACE);
            line.append(SIDE_RAIL);
        }
        return line.toString();
    }

    /**
     * 사다리를 화면에 출력하는 메서드
     */
    void printLadder() {
        StringBuilder lines = new StringBuilder();

        for (int i = 0; i < heightOfLadder; i++)
            lines.append(makeLine(i)).append("\n");
        System.out.println(lines);
    }
}
