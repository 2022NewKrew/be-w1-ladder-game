public class Ladder {
    private int width;
    private int height;
    private boolean[][] line;

    public Ladder(int numPeople, int ladderHeight) {
        this.width = numPeople - 1;
        this.height = ladderHeight;
        makeLines();
    }

    private void makeLines() {
        line = new boolean[height][width];

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                line[h][w] = Math.random() > 0.5;
            }
        }
    }

    @Override
    public String toString() {
        String ladder = "";
        for (int h = 0; h < height; h++) {
            ladder += "|";
            for (int w = 0; w < width; w++) {
                ladder += (line[h][w] == true ? "-" : " ") + "|";
            }
            ladder += "\n";
        }
        return ladder;
    }
}
