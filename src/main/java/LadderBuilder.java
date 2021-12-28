import java.util.ArrayList;
import java.util.Random;

public class LadderBuilder {
    private final Random random = new Random();
    private int numberOfPlayer = 0;
    private int height = 0;

    LadderBuilder(int numberOfPlayer, int height) {
        this.numberOfPlayer = numberOfPlayer;
        this.height = height;
    }

    /**
     * 가로 막대를 포함시킬지 말지 결정하는 메서드
     *
     * @return 포함시키면 true를 포함시키지 않으면 false를 반환한다
     */
    private Boolean getLineElement() {
        int MAX_RANDOM = 10;
        int RANDOM_RANGE = 3;

        return random.nextInt(MAX_RANDOM) < RANDOM_RANGE;
    }

    /**
     * Line을 만드는 메서드
     * 한 줄을 만들어서 반환한다
     *
     * @return Line 객체를 반환한다
     */
    private Line makeLine() {
        ArrayList<Boolean> line = new ArrayList<>();

        for (int i = 0; i < numberOfPlayer - 1; i++)
            line.add(getLineElement());
        return new Line(line);
    }

    /**
     * 사다리를 만드는 메서드
     *
     * @return Ladder 객체를 반환한다
     */
    Ladder makeLadder() {
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(makeLine());
        return new Ladder(lines);
    }
}
