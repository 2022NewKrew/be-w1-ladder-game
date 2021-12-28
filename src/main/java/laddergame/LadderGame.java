package laddergame;

import laddergame.ladder.Ladder;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderGame {
    private Ladder ladder = null;

    public void initGame() {
        try {
            ladder = createLadder();
        } catch (InputMismatchException e) {
            System.err.println("사다리 정보가 잘못되었음");
        }
    }

    public void showStatus() {
        try {
            ladder.printLadder();
        } catch (NullPointerException e) {
            System.err.println("사다리가 없음");
        }
    }

    private Ladder createLadder() {
        Scanner sc = new Scanner(System.in);
        int participantsNum, maxHeight;

        System.out.println("참여할 사람은 몇 명인가요?");
        participantsNum = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        maxHeight = sc.nextInt();
        if (participantsNum <= 0 || maxHeight <= 0)
            throw new InputMismatchException();
        return new Ladder(participantsNum, maxHeight);
    }
}
