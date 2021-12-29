package rubam.step2;

import java.util.List;
import java.util.Scanner;

public class Step2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("참여할 사람의 수를 입력하세요");
        int people = scanner.nextInt();
        System.out.println("사다리의 높이를 입력하세요");
        int height = scanner.nextInt();

        Ladder ladder = new Ladder(people, height);
        LadderPrinter.printLadder(ladder);
    }
}
