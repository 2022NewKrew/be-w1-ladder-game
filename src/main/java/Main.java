import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        System.out.println("참여할 사람은 몇 명인가요?");
        int n = in.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int m = in.nextInt();

        char[][] ladder = makeLadder(n, m);
        printLadder(ladder);
    }
}
