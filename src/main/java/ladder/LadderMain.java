package ladder;

import ladder.provider.LadderProvider;

import java.util.Scanner;

public class LadderMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers;
        int maxLadderHeight;

        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfPlayers = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxLadderHeight = scanner.nextInt();

        LadderProvider ladderProvider = new LadderProvider(maxLadderHeight, numberOfPlayers);
        System.out.println(ladderProvider.createLadder());
    }
}
