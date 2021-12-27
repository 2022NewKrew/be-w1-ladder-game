import java.util.Random;
import java.util.Scanner;

public class Application {
    public static int numOfPeople;
    public static int heightOfLadder;
    public static char[][] ladder;

    public static void runApp() {
        initializeLadder();
        makeRandomLadder();
        printLadder();
    }

    public static void initializeLadder() {
        input();
        ladder = new char[heightOfLadder][numOfPeople * 2 - 1];

        for (int i = 0; i < heightOfLadder; i++) {
            for (int j = 0; j < numOfPeople * 2 - 1; j++) {
                if (j % 2 == 0) {
                    ladder[i][j] = '|';
                } else {
                    ladder[i][j] = ' ';
                }
            }
        }
    }

    public static void makeRandomLadder() {
        Random random = new Random();

        for (int i = 0; i < heightOfLadder; i++) {
            for (int j = 1; j < numOfPeople * 2 - 1; j += 2) {
                if (j - 2 >= 0 && ladder[i][j - 2] == '-') {
                    continue;
                }

                if (random.nextBoolean()) {
                    ladder[i][j] = '-';
                }
            }
        }
    }

    public static void printLadder() {
        for (int i = 0; i < heightOfLadder; i++) {
            for (int j = 0; j < numOfPeople * 2 - 1; j++) {
                System.out.print(ladder[i][j]);
            }
            System.out.print('\n');
        }
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPeople = Integer.parseInt(scanner.nextLine());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {
        runApp();
    }
}
