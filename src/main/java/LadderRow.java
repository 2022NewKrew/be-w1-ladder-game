import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class LadderRow implements Iterable<Boolean> {
    private final int cols;
    private final ArrayList<Boolean> ladderRowData = new ArrayList<>();
    private final Random random = new Random();

    public LadderRow(int cols) {
        this.cols = cols;
        generateRandomLadderRow();
    }

    private void generateRandomLadderRow() {
        if (cols == 0) {
            return;
        }

        boolean leftExist = setFirstLadder();
        for (int i = 1; i < cols; ++i) {
            boolean ladderExist = !leftExist && random.nextBoolean();
            ladderRowData.add(ladderExist);
            leftExist = ladderExist;
        }
    }

    // To make the probability of all data equal (1/3)
    private boolean setFirstLadder() {
        boolean ladderExist = random.nextInt(2) == 0;
        ladderRowData.add(ladderExist);
        return ladderExist;
    }

    @Override
    public Iterator<Boolean> iterator() {
        return ladderRowData.iterator();
    }
}
