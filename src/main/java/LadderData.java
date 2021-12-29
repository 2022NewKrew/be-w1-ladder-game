import java.util.ArrayList;
import java.util.Iterator;

public class LadderData implements Iterable<LadderRow> {
    private final int rows;
    private final int cols;
    private final ArrayList<LadderRow> ladderData = new ArrayList<>();

    public LadderData(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        generateRandomData();
    }

    private void generateRandomData() {
        for (int i = 0; i < rows; ++i) {
            ladderData.add(new LadderRow(cols));
        }
    }

    @Override
    public Iterator<LadderRow> iterator() {
        return ladderData.iterator();
    }
}
