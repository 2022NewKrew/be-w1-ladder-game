package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        // todo - 사이즈가 0 이하면 에러 처리하기
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder valueOf(int countOfPerson, int ladderHeight) {
        final List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(Line.valueOf(countOfPerson));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
