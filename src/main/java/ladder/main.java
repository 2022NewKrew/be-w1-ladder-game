package ladder;

import java.util.Scanner;
import java.lang.Math;

public class main {
    public static void main(String[] args) {

        char[][] ladder;

        Scanner sc = new Scanner(System.in);
        int N = getScanner(sc, "참여할 사람은 몇명인가요?");
        int col = N * 2 - 1;
        int row = getScanner(sc,"최대 사다리 높이는 몇 개인가요?");

        ladder = new char[row][col];

        initLadder(ladder, col, row);
        printLadder(ladder, col, row);

    }

    private static void initLadder(char[][] ladder, int col, int row) {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (j % 2 == 0)
                    ladder[i][j] = '|';
                else
                    ladder[i][j] = ' ';
            }
            ladder[i][(int) (Math.random() * (col / 2)) * 2 + 1] = '-';
        }
    }

    private static int getScanner(Scanner sc, String str) {
        System.out.println(str);
        int N = sc.nextInt();
        return N;
    }



    private static void printLadder(char[][] ladder, int col, int row) {
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                System.out.print(ladder[i][j]);
            }
            System.out.println();
        }
    }
}
