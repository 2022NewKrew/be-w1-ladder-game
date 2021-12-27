import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = _getIntegerFromScanner(scanner, "참여할 사람은 몇 명인가요? ");
        int height = _getIntegerFromScanner(scanner, "사다리 높이는 몇개인가요? ");

        char[][] ladder = _generateLadder(count, height);
        _fillLadder(ladder);
        _printLadder(ladder);
    }

    /**
     * @return {@code scanner}로부터 입력받은 정수
     */
    private static int _getIntegerFromScanner(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("** 정수를 입력해주세요 **");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * @param count 사람 수
     * @param height 사다리 높이
     * @return 빈 사다리
     */
    private static char[][] _generateLadder(int count, int height) {
        int width = 2 * count - 1;
        return new char[height][width];
    }

    /**
     * {@code ladder} 내부를 랜덤하게 채움
     */
    private static void _fillLadder(char[][] ladder) {
        for (int i=0; i<ladder.length; ++i) {
            for (int j=0; j<ladder[0].length; ++j) {
                if (j % 2 == 0) {
                    ladder[i][j] = '|';
                } else {
                    ladder[i][j] = (Math.random() < 0.5 ? '-' : ' ');
                }
            }
        }
    }

    /**
     * {@code ladder} 출력
     */
    private static void _printLadder(char[][] ladder) {
        for (char[] chars : ladder) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}