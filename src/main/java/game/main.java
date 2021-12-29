package game;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class main {
    public static void main(String[] args) {


        int N = getIntegerInput("참여할 사람은 몇명인가요?");
        int col = N * 2 - 1;
        int row = getIntegerInput("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(row, col);
        ladder.initLadder();
        ladder.printLadder();
    }

    private static int getIntegerInput(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        int result = -1;
        while (!sc.hasNextInt() || ((result = sc.nextInt()) < 0)) {
            sc = new Scanner(System.in);
            System.out.println("양의 점수를 입력해 주세요.");
        }
        return result;


    }
}
