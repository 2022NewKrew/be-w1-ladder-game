package stepone;

import java.util.Scanner;

public class LadderStepOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇명인가요?");
        int numPlayers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = scanner.nextInt();
        scanner.close();

        Ladder ladder = new Ladder(ladderHeight, numPlayers);
        ladder.printLadder();
    }

}
