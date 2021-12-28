import java.util.*;

public class Main {

    public static void main(String[] args) {
        int numberOfPlayer = 0;
        int height = 0;

        try {
            numberOfPlayer = Input.inputNumberOfPlayer();
            height = Input.inputHeight();
        } catch (InputMismatchException e) {
            System.err.println("0보다 큰 정수를 입력해주세요");
            System.exit(1);
        }
        LadderBuilder ladderBuilder = new LadderBuilder(numberOfPlayer, height);
        Ladder ladder = ladderBuilder.makeLadder();
        Output.printLadder(ladder.getLadder());
    }
}
