import java.util.ArrayList;


public class Ladder {
    private final int height;
    private final int width;
    private final ArrayList<Line> ladderInfo = new ArrayList<>();  // First class collection 적용해보기

    public Ladder(int height, int numOfPlayers) {
        this.height = height;
        this.width = numOfPlayers * 2 - 1;
        addLadderInfo();
    }

    private void addLadderInfo() {
        for (int i = 0; i < height; i++) {
            Line newLine = new Line(width);
            this.ladderInfo.add(newLine);
        }
    }

    public ArrayList<Line> getLadderInfo() {
        return ladderInfo;
    }
}