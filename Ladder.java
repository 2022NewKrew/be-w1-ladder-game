import java.util.Random;

public class Ladder {
    private final int N;
    private final int M;
    private final char[][] ladder;

    public Ladder(int N, int M) {
        this.N = N;
        this.M = M;
        ladder = new char[M][N * 2 - 1];
    }

    public void makeLadder() {
        Random rd = new Random();
        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N * 2 - 1; j ++) {
                if(j % 2 == 0) ladder[i][j] = '|';
                else ladder[i][j] = rd.nextBoolean() ? '-' : ' ';
            }
        }
    }

    public void printLadder() {
        for(int i = 0; i < M; i ++) {
            for(int j = 0; j < N * 2 - 1; j ++) {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}
