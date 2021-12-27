public class Line {
    private final int lineIndex;
    private final boolean[][] connectMap;

    public Line(int lineIndex, int gamePlayerNum, int maxLadderHeight) {
        this.lineIndex = lineIndex;
        this.connectMap = new boolean[gamePlayerNum][maxLadderHeight];
    }

    public void connect(int line, int height) {
        this.connectMap[line][height] = true;
    }

    public boolean isConnected(int line, int height) {
        return connectMap[line][height];
    }
}
