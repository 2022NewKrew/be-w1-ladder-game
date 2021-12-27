public class Ladder {
    private final int width;
    private final int height;
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
        StringBuilder ladder = new StringBuilder();
        for (int h = 0; h < height; h++) {
            ladder.append("|");
            for (int w = 0; w < width; w++) {
                ladder.append(line[h][w] ? "-" : " ").append("|");
            }
            ladder.append("\n");
        }
        return ladder.toString();
    }
}
