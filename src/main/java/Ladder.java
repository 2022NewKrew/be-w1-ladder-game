import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int countOfPerson;
    private final int height;
    private final List<Line> lines;

    Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
        this.lines = new ArrayList<>(height);
        setLadder();
    }

    private void setLadder() {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
