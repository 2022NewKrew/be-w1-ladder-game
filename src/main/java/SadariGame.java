import java.io.IOException;
import java.util.Scanner;

public class SadariGame {

    private static int numberOfPeople;
    private static int numberOfLadder;

    public static void main(String[] args) throws IOException {
        input();
        printSadariGame(numberOfPeople * 2 - 1, numberOfLadder);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        numberOfPeople = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        numberOfLadder = sc.nextInt();
    }

    private static void printSadariGame(int numberOfColumnLine, int numberOfRowLine) {
        for (int i = 0; i < numberOfRowLine; i++)
            printRowLine(numberOfColumnLine);
    }

    private static void printRowLine(int numberOfColumnLine) {
        for (int j = 0; j < numberOfColumnLine; j++) {
            if (isBorder(j))
                printSadariBorder();
            else
                printSadariLine(j);
        }

        System.out.println();
    }

    private static void printSadariBorder() {
        System.out.print("|");
    }

    private static void printSadariLine(int j) {
        if (canPrintSadariLine())
            System.out.print("-");
        else
            System.out.print(" ");
    }

    private static boolean isBorder(int j) {
        return j % 2 == 0;
    }

    private static boolean canPrintSadariLine() {
        // 0~1 정수를 랜덤하게 가져와 0이면 사다리 라인을 그린다.
        return (int)(Math.random()*2) == 0;
    }
}
