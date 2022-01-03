package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LadderBuilder {
    private final int height;
    private final LineBuilder lineBuilder;

    LadderBuilder(int numberOfPlayer, int height) {
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
    Ladder makeLadder() {
        List<Line> lines = Stream.generate(lineBuilder::makeLine)
                .limit(height)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
