import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<StringBuilder> ladder = new ArrayList<>();
    private final int heights;
    private final int noParticipants;

    public Ladder(int heights, int noParticipants) {
        this.noParticipants = noParticipants;
        this.heights = heights;
        for (int i = 0; i < heights; i++){
            ladder.add(new StringBuilder());
        }
    }

    public int getHeights() {
        return heights;
    }

    public int getNoParticipants() {
        return noParticipants;
    }

    public ArrayList<StringBuilder> getLadder() {
        return ladder;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("\n");
        for (int i = 0; i < heights; i++){
            res.append(ladder.get(i).toString()).append("\n");
        }
        return res.toString();
    }
}
