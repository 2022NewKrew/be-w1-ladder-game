import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int playerNum;
    private final int maxLadderHeight;

    public Ladder(GameStartInfo info) {
        this.lines = createLines(info.getGamePlayerNum(), info.getMaxLadderHeight());
        this.playerNum = info.getGamePlayerNum();
        this.maxLadderHeight = info.getMaxLadderHeight();
    }

    public void connect(int firstLine, int secondLine, int height) {
        this.lines.get(firstLine).connect(secondLine, height);
        this.lines.get(secondLine).connect(firstLine, height);
    }

    public boolean isConnected(int firstLine, int secondLine, int height) {
        return lines.get(firstLine).isConnected(secondLine, height);
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    private List<Line> createLines(int playerNum, int maxLadderHeight) {
        List<Line> lines = new ArrayList<>();
        for(int lineIndex = 0; lineIndex < playerNum; lineIndex++) {
            lines.add(new Line(lineIndex, playerNum, maxLadderHeight));
        }
        return lines;
    }
}
