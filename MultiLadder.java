import java.util.Random;

public class MultiLadder extends Ladder {
    private final int N;
    private final int M;
    private final boolean[][] bridge;

    public MultiLadder(int N, int M) {
        this.N = N;
        this.M = M;
        bridge = new boolean[M][N-1];
        makeBridge();
    }

    private void makeBridgeRow(int m) {
        Random rd = new Random();
        for(int j = 0; j < N - 1; j ++) {
            bridge[m][j] = rd.nextBoolean();
        }
    }

    public void makeBridge() {
        for(int i = 0; i < M; i ++) {
            makeBridgeRow(i);
        }
    }

    private void printCell(int m, int n) {
        if(bridge[m][n]) {
            System.out.print('-');
            return;
        }
        System.out.print(' ');
    }

    private void printRow(int m) {
        System.out.print('|');
        for(int j = 0; j < N - 1; j ++) {
            printCell(m, j);
            System.out.print('|');
        }
    }

    public void printLadder() {
        for(int i = 0; i < M; i ++) {
            printRow(i);
            System.out.println();
        }
    }

}
