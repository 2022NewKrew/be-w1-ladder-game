public class Ladder {
    private final int width;
    private final int height;
    private boolean[][] ladder;

    public Ladder(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean[][] getLadder() {
        return ladder;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setLadder(boolean[][] ladder) {
        this.ladder = ladder;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < height; ++i){
            for(int j = 0 ; j < width-1; ++j){
                stringBuilder.append(ladder[i][j] ? "|-" : "| " );
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }
}