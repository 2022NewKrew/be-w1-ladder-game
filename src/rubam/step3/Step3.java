package rubam.step3;

import java.util.Scanner;

public class Step3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Ladder ladder = Ladder.createLadder();
        LadderPrinter.printLadder(ladder);
    }
}
