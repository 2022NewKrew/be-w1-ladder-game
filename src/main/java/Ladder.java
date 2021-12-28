import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    int MAX_RANDOM = 10;
    int RANDOM_RANGE = 3;
    String SIDE_RAIL = "|";
    String RUNG = "-";
    String SPACE = " ";

    int numberOfRung = 0;
    int heightOfLadder = 0;
    ArrayList<Boolean> rungs;
    Random random = new Random();

    /**
     * 한 줄에 Rung이 몇 개인지, 사다리의 길이는 얼마인지 저장하고 사다리를 생성한다.
     * @param numberOfPlayer
     * @param height
     */
    Ladder(int numberOfPlayer, int height) {
        numberOfRung = numberOfPlayer - 1;
        heightOfLadder = height;
        makeLadder();
    }

    /**
     * 사다리의 한 줄을 만들어주는 메서드
     * @param heightIdx 현재 몇 번째 줄에 있는지 인자로 받는다
     * @return 사다리의 한 줄을 String으로 만들어서 반환한다
     */
    String makeLine(int heightIdx) {
        StringBuilder line = new StringBuilder(SIDE_RAIL);

        for (int i = 0; i < numberOfRung; i++) {
            line.append(rungs.get(numberOfRung * heightIdx + i) ? RUNG : SPACE);
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

    /**
     * 렌덤값에 따라 Rung 값을 생성해준다
     * @return Rung이 있다면 true를 없다면 false를 반환한다
     */
    Boolean getRungElement() {
        return random.nextInt(MAX_RANDOM) < RANDOM_RANGE;
    }

    /**
     * 사다리를 만드는 메서드
     * Rung 리스트를 만들어준다
     */
    void makeLadder() {
        rungs = new ArrayList<>();

        for (int i = 0; i < numberOfRung * heightOfLadder; i++) {
            rungs.add(getRungElement());
        }
    }
}
