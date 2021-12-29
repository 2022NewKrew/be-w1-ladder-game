import java.util.ArrayList;


public class Ladder {
    private int height;
    private int width;
    public ArrayList<Line> ladderInfo;


    public Ladder(int height, int numOfPlayers) {
        this.height = height;
        this.width = numOfPlayers * 2 - 1;
        getLadderInfo();
    }

    public void getLadderInfo() {
        this.ladderInfo = new ArrayList<Line>();
        for (int i = 0; i < height; i++) {
            Line newLine = new Line(width);
            this.ladderInfo.add(newLine);
        }
    }
}
