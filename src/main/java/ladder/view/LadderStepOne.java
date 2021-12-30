package ladder.view;

import java.util.Scanner;


public class LadderStepOne {
    final Scanner scanner = new Scanner(System.in);

    public int getPlayers() {
        System.out.println("참여할 사람은 몇명인가요?");
        return scanner.nextInt();
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }


}