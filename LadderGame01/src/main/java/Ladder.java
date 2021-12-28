public class Ladder {
    private final int width;
    private final int height;
    private boolean[][] ladder;

    public Ladder(int width, int height){
        if(width < 1 || height < 1)
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
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
        for(int r = 0 ; r < height; ++r){
            for(int c = 0 ; c < width-1; ++c){
                stringBuilder.append(ladder[r][c] ? "|-" : "| " );
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }

}