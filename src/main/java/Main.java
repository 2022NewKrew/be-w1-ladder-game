import java.util.*;

public class Main {
    static int numberOfPlayer = 0;
    static int height = 0;
    static char[][] ladders;

    /**
     * 사다리를 화면에 출력하는 메서드
     */
    static void printLadder() {
        for (char[] ladder : ladders) {
            for (int j = 0; j < ladders[0].length; j++)
                System.out.printf("%c", ladder[j]);
            System.out.println();
        }
    }

    /**
     * 사람 수와 사다리 높이를 인자로 받아 사다리를 생성하는 메서드
     */
    static void makeLadder() {
        ladders = new char[height][2 * numberOfPlayer - 1];

        Random random = new Random();

        for (int i = 0; i < ladders.length; i++) {
            for (int j = 0; j < ladders[i].length; j++) {
                if (j % 2 == 0)
                    ladders[i][j] = '|';
                else if (random.nextInt(10) < 3)
                    ladders[i][j] = '-';
                else
                    ladders[i][j] = ' ';
            }
        }
    }

    static void validateInput(int input) {
        if (input <= 0)
            throw new InputMismatchException();
    }

    static void input() throws InputMismatchException {
        Scanner in = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfPlayer = in.nextInt();
        validateInput(numberOfPlayer);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = in.nextInt();
        validateInput(height);
    }

    public static void main(String[] args) {
        try {
            input();
        } catch (InputMismatchException e) {
            System.out.println("0보다 큰 정수를 입력해주세요");
            e.printStackTrace();
            return;
        }
        makeLadder();
        printLadder();
    }
}
