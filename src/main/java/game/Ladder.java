package game;

public class Ladder {
    private final int row;
    private final int col;
    private final char array[][];

    public Ladder(int row, int col) {
        this.row = row;
        this.col = col;
        this.array = new char[row][col];
    }

    public void initLadder() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j % 2 == 0)
                    array[i][j] = '|';
                else
                    array[i][j] = ' ';
            }
            // 한 줄에 하나씩만 bridge 연결하도록 설정
            int randomIndex = (int) (Math.random() * (col / 2)) * 2 + 1;
            array[i][randomIndex] = '-';
        }
    }

    public void printLadder() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
