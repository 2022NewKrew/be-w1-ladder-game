package Mission2;

import java.util.Random;

public class Ladder {

    // 인스턴스 변수
    private int[][] matrix;
    int n;
    int m;

    // 생성자
    public Ladder(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new int[m][n-1];
    }

    // 전체 실행 메소드
    public void routine() {
        this.makeRow();
        this.printRow();
    }
    
    public void makeRow() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        for(int i = 0; i < this.m; i++) {
            this.matrix[i] = makeCol();
        }
    }

    public int[] makeCol() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int[] ret = new int[this.n - 1];
        for (int i = 0; i < this.n - 1; i++) {
            ret[i] = random.nextInt(2);
        }
        return ret;
    }

    public void printRow() {
        for(int i = 0; i < this.m; i++) {
            printCol(this.matrix[i]);
        }
    }

    public void printCol(int[] currentRow) {
        for(int i = 0; i < this.n - 1; i++) {
            System.out.print(returnFlag(currentRow[i]));
        }
        System.out.println("|");
    }

    public String returnFlag(int flag) {
        if (flag == 0) {
            return "|-";
        }
        return "| ";
    }
}
