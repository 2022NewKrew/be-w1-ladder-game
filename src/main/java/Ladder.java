import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int height;
    private int width;
    private List<CrossLine> crossLines;

    public Ladder(int height, int numOfPeople) {
        this.height = height;
        this.width = numOfPeople - 1;
        this.crossLines = new ArrayList<>();
        initializeCrossLines();
    }

    public void initializeCrossLines() {
        for (int i = 0; i < height; i++) {
            crossLines.add(new CrossLine(width));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < height; i++) {
            sb.append(crossLines.get(i).toString() + "\n");
        }

        return sb.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<CrossLine> getCrossLines() {
        return crossLines;
    }
}
