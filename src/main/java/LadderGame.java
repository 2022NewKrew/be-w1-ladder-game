import java.util.InputMismatchException;
import java.util.Scanner;

public class LadderGame {
    private Ladder ladder = null;

    public void initGame() {
        Scanner sc = new Scanner(System.in);
        int participantsNum, maxHeight;
        try {
            System.out.println("참여할 사람은 몇 명인가요?");
            participantsNum = sc.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            maxHeight = sc.nextInt();
            if (participantsNum <= 0 || maxHeight <= 0)
                throw new InputMismatchException();
            ladder = new Ladder(participantsNum, maxHeight);
        } catch (InputMismatchException e) {
            System.err.println("양의 정수를 입력하셈");
        }
    }

    public void showStatus() {
        try {
            ladder.printLadder();
        } catch (NullPointerException e) {}
    }
}
