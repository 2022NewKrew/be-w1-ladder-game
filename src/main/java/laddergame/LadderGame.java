package laddergame;

import java.util.Scanner;

public class LadderGame {

    Scanner scanner = new Scanner(System.in);

    private Ladder ladder;

    public void printLadder(int ladderCount) {
        for (int i = 0; i < ladderCount; i++) {
            ladder.getLadder().get(i).forEach(this::printEachLadderComponent);
            System.out.println();
        }
    }

    private void printEachLadderComponent(LadderComponent ladderComponent) {
        if (ladderComponent.getHasVertical()) {
            System.out.print("|-");
        } else {
            System.out.print("| ");
        }
    }

    public Integer readUserCount() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public Integer readLadderCount() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
}
