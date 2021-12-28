import java.util.*;

public class Main {

    public static void main(String[] args) {
        LadderBuilder ladderBuilder = new LadderBuilder();

        try {
            ladderBuilder.input();
        } catch (InputMismatchException e) {
            System.err.println("0보다 큰 정수를 입력해주세요");
            System.exit(1);
        }

        Ladder ladder = ladderBuilder.buildLadder();
        ladder.printLadder();
    }
}
