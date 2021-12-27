package ladder.view;

import java.util.Scanner;

public class InputView {

    static Scanner sc = new Scanner(System.in);

    public static int inputPerson() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public static int inputLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderCount = sc.nextInt();
        System.out.println();
        return ladderCount;
    }


}
