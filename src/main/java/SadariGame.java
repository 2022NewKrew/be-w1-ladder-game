import java.util.Random;
import java.util.Scanner;

public class SadariGame {

    public static void main(String[] args) {
        SadariInfo sadariInfo = input();
        printSadariGame(sadariInfo.getNumberOfColumn(), sadariInfo.getNumberOfRow());
    }

    private static SadariInfo input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        int numberOfPeople = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int numberOfLadder = sc.nextInt();

        return new SadariInfo(numberOfPeople, numberOfLadder);
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
        return new Random().nextBoolean();

    }
}
