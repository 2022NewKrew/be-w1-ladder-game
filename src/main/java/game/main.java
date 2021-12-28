package game;

import java.util.Scanner;
import java.lang.Math;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = getScanner(sc, "참여할 사람은 몇명인가요?");
        int col = N * 2 - 1;
        int row = getScanner(sc,"최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(row,col);
        ladder.initLadder();
        ladder.printLadder();
    }
    private static int getScanner(Scanner sc, String str) {
        System.out.println(str);
        return sc.nextInt();
    }
}
