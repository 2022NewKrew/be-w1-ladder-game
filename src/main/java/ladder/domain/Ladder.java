package ladder.domain;

<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    Ladder(List<Line> lines) {
        if (lines == null)
            throw new IllegalArgumentException();
        this.lines = Collections.unmodifiableList(lines);
    }

<<<<<<< HEAD
    int play(int startIndex) {
        int currentIndex = startIndex;

        for (Line line : lines)
            currentIndex = line.move(currentIndex);
        return currentIndex;
    }

=======
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
    public List<Line> getLadder() {
        return lines;
    }
}
