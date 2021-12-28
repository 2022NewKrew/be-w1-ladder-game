import java.util.ArrayList;
import java.util.Random;

public class LadderBuilder {
    private final int MAX_RANDOM = 10;
    private final int RANDOM_RANGE = 3;
    private int numberOfPlayer = 0;
    private int height = 0;
    private final Random random = new Random();

    LadderBuilder(int numberOfPlayer, int height) {
        this.numberOfPlayer = numberOfPlayer;
        this.height = height;
    }

    /**
     * 렌덤값에 따라 Rung 값을 생성해준다
     *
     * @return Rung이 있다면 true를 없다면 false를 반환한다
     */
    Boolean getLineElement() {
        return random.nextInt(MAX_RANDOM) < RANDOM_RANGE;
    }

    /**
     * 사다리를 만드는 메서드
     * Ladder 객체를 반환해준다
     * @return
     */
    Ladder makeLadder() {
        ArrayList<Boolean> lines = new ArrayList<>();
        int numberOfRung = numberOfPlayer - 1;
        int heightOfLadder = height;

        for (int i = 0; i < numberOfRung * heightOfLadder; i++) {
            lines.add(getLineElement());
        }
        return new Ladder(numberOfRung, heightOfLadder, lines);
    }
}
