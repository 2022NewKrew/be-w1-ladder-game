package ladder.domain;

<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
import java.util.List;

public class Line {
    private final List<Boolean> line;

    Line(List<Boolean> line) {
        if (line == null)
            throw new IllegalArgumentException();
        this.line = Collections.unmodifiableList(line);
    }

<<<<<<< HEAD
    int move(int idx) {
        if (idx != 0 && line.get(idx - 1))
            return idx - 1;
        if (idx != line.size() && line.get(idx))
            return idx + 1;
        return idx;
    }

=======
>>>>>>> 01c34da0c1a9889ac35531770c2259bd8ba26763
    public List<Boolean> getLine() {
        return line;
    }
}