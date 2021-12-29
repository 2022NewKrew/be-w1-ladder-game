import java.util.ArrayList;

public class Ladder {
    private static final int WIDTH_CORRECTION = 1;
    private static final String SPACE = "  ";

    private final ArrayList<LadderRow> bridges = new ArrayList<>();

    public Ladder(int numPeople, int ladderHeight) {
        for (int h = 0; h < ladderHeight; h++) {
            bridges.add(new LadderRow(numPeople - WIDTH_CORRECTION));
        }
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        for (LadderRow line : bridges) {
            ladder.append(SPACE).append(line).append("\n");
        }
        return ladder.toString();
    }
}
