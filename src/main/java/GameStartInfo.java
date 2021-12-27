public class GameStartInfo {
    private final int gamePlayerNum;
    private final int maxLadderHeight;

    public GameStartInfo(int gamePlayerNum, int maxLadderHeight) {
        this.gamePlayerNum = gamePlayerNum;
        this.maxLadderHeight = maxLadderHeight;
    }

    public int getGamePlayerNum() {
        return gamePlayerNum;
    }

    public int getMaxLadderHeight() {
        return maxLadderHeight;
    }
}
