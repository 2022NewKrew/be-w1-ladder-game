import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class LadderRow implements Iterable<Boolean> {
    private final int numParticipants;
    private final ArrayList<Boolean> ladderRowData = new ArrayList<>();
    private final Random random = new Random();

    public LadderRow(int numParticipants) {
        this.numParticipants = numParticipants;
        generateRandomLadderRow();
    }

    private void generateRandomLadderRow() {
        if (numParticipants == 1) {
            return;
        }

        boolean leftExist = setFirstLadder();
        for (int i = 1; i < numParticipants - 1; ++i) {
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
