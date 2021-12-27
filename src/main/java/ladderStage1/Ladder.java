package ladderStage1;

import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private int manCnt;
    private int maxHeight;
    private boolean[][] ladderArr;

    public void init() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        manCnt = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxHeight = sc.nextInt();

        ladderArr = new boolean[maxHeight][manCnt - 1];
    }

    public void make() {
        Random random = new Random();
        for(int row = 0; row < maxHeight; row++) {
            for(int col = 0; col < manCnt - 1; col++) {
                ladderArr[row][col] = random.nextInt(2) == 1;
            }
        }
    }

    public void print() {
        for(int row = 0; row < maxHeight; row++) {
            for(int col = 0; col < manCnt - 1; col++) {
                System.out.print("|");
                System.out.print(ladderArr[row][col] ? "-" : " ");
            }
            System.out.println("|");
        }
    }
}