import java.util.ArrayList;

public class LadderBuilder {
    private int height = 0;
    private final LineBuilder lineBuilder;

    LadderBuilder(int numberOfPlayer, int height) {
        this.height = height;
        lineBuilder = new LineBuilder(numberOfPlayer);
    }

    /**
     * 사다리를 만드는 메서드
     *
     * @return Ladder 객체를 반환한다
     */
    Ladder makeLadder() {
        ArrayList<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++)
            lines.add(lineBuilder.makeLine());
        return new Ladder(lines);
    }
}
