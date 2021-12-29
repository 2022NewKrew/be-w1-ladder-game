/*
 * @author ed.shim
 */
package ladderGame;

import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(getInput());
        ladder.print();
    }

    static int[] getInput() {
        int[] args = new int[2];
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        args[0] = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        args[1] = scanner.nextInt();

        scanner.close();
        return args;
    }
}
