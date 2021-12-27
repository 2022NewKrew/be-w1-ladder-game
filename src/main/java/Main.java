import java.util.*;

public class Main {
    /**
     * 사다리를 화면에 출력하는 메서드
     *
     * @param ladder 사다리 배열을 입력 받는다
     */
    static void printLadder(char[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j++)
                System.out.printf("%c", ladder[i][j]);
            System.out.println();
        }
    }

    /**
     * 사람 수와 사다리 높이를 인자로 받아 사다리를 생성하는 메서드
     *
     * @param number 사람 수
     * @param height 사다리 높이
     * @return 사다리 배열
     */
    static char[][] makeLadder(int number, int height) {
        char[][] ladder = new char[height][2 * number -1];

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j % 2 == 0)
                    ladder[i][j] = '|';
                else if (random.nextInt(10) < 3)
                    ladder[i][j] = '-';
                else
                    ladder[i][j] = ' ';
            }
        }

        return ladder;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, m = 0;

        try {
            System.out.println("참여할 사람은 몇 명인가요?");
            n = in.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            m = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요");
            e.printStackTrace();
            return ;
        }

        if (n <= 0 || m <= 0)
            System.out.println("0보다 큰 정수를 입력해주세요");

        char[][] ladder = makeLadder(n, m);
        printLadder(ladder);
    }
}
