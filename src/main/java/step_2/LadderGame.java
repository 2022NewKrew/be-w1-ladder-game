package step_2;

import java.util.Scanner;

import static step_2.Validator.checkPositiveInteger;

public class LadderGame {
    private Ladder ladder;

    private final LadderBuilder ladderBuilder = new LadderBuilder();

    public void start() throws Exception {
        inputGameConditions();

        ladderBuilder.buildLadder(ladder);

        printLadder();
    }

    private void inputGameConditions() throws Exception {
        int ladderWidth, ladderHeight;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            ladderWidth = scanner.nextInt();
            checkPositiveInteger(ladderWidth, "사람의 수는 0명보다 커야합니다.");

            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            ladderHeight = scanner.nextInt();
            checkPositiveInteger(ladderHeight, "사다리의 높이는 0보다 커야합니다.");
        }

        ladder = new Ladder(ladderWidth, ladderHeight);
    }

    private void printLadder() {
        System.out.println(ladder.getShape());
    }
}
