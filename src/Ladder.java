import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int numOfPeople, int height) {
        int width = 2 * numOfPeople - 1;

        createLines(height, width);
    }

    private void createLines(int height, int width) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(width);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
