import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int numOfPeople, int height) {
        createLines(height, numOfPeople);
    }

    private void createLines(int height, int numOfPeople) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(numOfPeople);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
