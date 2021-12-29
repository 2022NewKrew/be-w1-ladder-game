import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final static String VIEW_BRIDGE = "-----|";
    private final static String VIEW_EMPTY = "     |";
    private final static Random rand = new Random();
    private List<Line> ladder;

    public void setLadder(int players, int height) {
        ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line curLine = new Line();
            curLine.setLine(players);
            ladder.add(curLine);
        }
    }

    public List<Line> getLadder() {
        if (ladder == null) return null;
        return ladder;
    }

    public static class Line {

        private final List<Boolean> points = new ArrayList<>();

        public List<Boolean> getLine() {
            return points;
        }

        public void setLine(int players) {
            for (int i = 0; i < players - 1; i++) {
                points.add(buildRandomBridge());
            }
        }

        public String toString() {
            String str = "|";
            for (Boolean bool : points) {
                str = str.concat(bool ? VIEW_BRIDGE : VIEW_EMPTY);
            }

            return str;
        }

        private Boolean canBuildBridge() {
            if (points.isEmpty()) return true;
            return !points.get(points.size() - 1);
        }

        private Boolean buildRandomBridge() {
            if (!canBuildBridge()) return false;
            return rand.nextBoolean();
        }
    }
}
