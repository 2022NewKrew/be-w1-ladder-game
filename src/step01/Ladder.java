package step01;

public class Ladder {
    private int width;
    private int height;
    private char[][] result;

    public Ladder() {
    }

    public Ladder(int n, int m) {
        this.width = n * 2 - 1;
        this.height = m;
        this.result = new char[this.height][this.width];
    }

    public void initLadder() {
        for(int i = 0; i < this.height; ++i) {
            for(int j = 0; j < this.width; ++j) {
                if (j % 2 == 0) {
                    this.result[i][j] = '|';
                } else {
                    this.result[i][j] = (char)((int)(Math.random() * 10.0D) % 2 == 0 ? 45 : 32);
                }
            }
        }

    }

    public void draw() {
        for(int i = 0; i < this.height; ++i) {
            System.out.println(String.valueOf(this.result[i]));
        }
    }
}
