package step_2;

import java.util.Scanner;

public class LadderGame {
    private Ladder ladder;
    private int ladderWidth, ladderHeight;

    private final Validator validator = new Validator();
    private final LadderBuilder ladderBuilder = new LadderBuilder();

    public void start() throws Exception {
        inputGameConditions(this);

        ladder = ladderBuilder.buildLadder(ladderWidth, ladderHeight);

        printLadder();
    }

    private void inputGameConditions(LadderGame ladderGame) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            ladderGame.ladderWidth = scanner.nextInt();
            validator.checkPositiveInteger(ladderGame.ladderWidth, "사람의 수는 0명보다 커야합니다.");

            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            ladderGame.ladderHeight = scanner.nextInt();
            validator.checkPositiveInteger(ladderGame.ladderHeight, "사다리의 높이는 0보다 커야합니다.");
        }
    }

    private void printLadder() {
        System.out.println(ladder.shape);
    }
}
