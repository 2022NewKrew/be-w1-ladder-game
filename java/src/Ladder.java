import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final char[] CHARSET = {' ', '-'};
    private List<Line> ladder;

    public void setLadder(int players, int height) {
        ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line curLine = new Line();
            curLine.setLine(players, CHARSET);
            ladder.add(curLine);
        }
    }

    public List<Line> getLadder() {
        if (ladder == null) return null;
        return ladder;
    }
}
