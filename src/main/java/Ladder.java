import java.util.ArrayList;
import java.util.Iterator;

public class Ladder implements Iterable<LadderRow> {
    private final LadderInfo ladderInfo;
    private final ArrayList<LadderRow> ladderData = new ArrayList<>();

    public Ladder(LadderInfo ladderInfo) {
        this.ladderInfo = ladderInfo;
        generateRandomLadder();
    }

    private void generateRandomLadder() {
        for (int i = 0; i < ladderInfo.getMaxLadderHeight(); ++i) {
            ladderData.add(new LadderRow(ladderInfo.getNumParticipants()));
        }
    }

    @Override
    public Iterator<LadderRow> iterator() {
        return ladderData.iterator();
    }
}
