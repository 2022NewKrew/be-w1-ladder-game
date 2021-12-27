package step_1;

import java.util.Scanner;
import java.util.Random;

public class LadderGame {
    private final StringBuilder ladderMap = new StringBuilder();

    private int numParticipants;
    private int maxLadderHeight;

    private void inputGameConditions() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            numParticipants = scanner.nextInt();
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            maxLadderHeight = scanner.nextInt();
        }
        System.out.println();
    }

    private void buildVerticalLadder() {
        Random random = new Random();

        if (random.nextBoolean())
            ladderMap.append("-");
        else
            ladderMap.append(" ");
    }

    private void buildHorizontalLadder() {
        ladderMap.append("|");
    }

    private void buildLadder() {
        for (int i = 0; i < maxLadderHeight; i++) {
            for (int j = 0; j < numParticipants * 2 - 1; j++) {
                if (j % 2 == 0)
                    this.buildHorizontalLadder();
                else
                    this.buildVerticalLadder();
            }
            ladderMap.append("\n");
        }
    }

    private void printLadder() {
        System.out.println(ladderMap);
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        ladderGame.inputGameConditions();
        ladderGame.buildLadder();
        ladderGame.printLadder();
    }
}
