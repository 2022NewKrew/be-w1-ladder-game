package ladder.domain;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
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
<<<<<<< HEAD
    Ladder makeLadder() {
        List<Line> lines = Stream.generate(lineBuilder::makeLine)
=======
    public Ladder makeLadder() {
        List<Line> lines = new ArrayList<>();

        Stream.generate(lineBuilder::makeLine)
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
                .limit(height)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }
}
