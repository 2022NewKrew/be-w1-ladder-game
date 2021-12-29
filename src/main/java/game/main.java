package game;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {


        int numOfPerson = getIntegerInput("참여할 사람은 몇명인가요?");
        int height = getIntegerInput("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(numOfPerson, height);
        ladder.printLadder();
    }

    private static int getIntegerInput(String str) {
        Scanner sc = new Scanner(System.in);
        System.out.println(str);
        int result = -1;
        while (!sc.hasNextInt() || ((result = sc.nextInt()) < 0)) {

            System.out.println("양의 점수를 입력해 주세요.");
            sc.next();
        }
        return result;

    }
}