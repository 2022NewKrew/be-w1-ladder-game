package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderBuilder {
    private final int height;
    private final LineBuilder lineBuilder;

    public LadderBuilder(int numberOfPlayer, int height) {
        if (height <= 0 || numberOfPlayer <= 0)
            throw new IllegalArgumentException();
        this.height = height;
        lineBuilder = new LineBuilder(numberOfPlayer);
    }

    /**
     * 사다리를 만드는 메서드
     *
     * @return ladder.domain.Ladder 객체를 반환한다
     */
    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();

        Stream.generate(lineBuilder::makeLine)
                .limit(height)
                .forEachOrdered(lines::add);
        return new Ladder(lines);
    }
}
