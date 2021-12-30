package rubam.step4;

import rubam.step4.domain.Ladder;
import rubam.step4.input.InputLadderInform;
import rubam.step4.view.LadderPrinter;

public class Step4 {

    public static void main(String[] args) {

        Ladder ladder = InputLadderInform.userInput();
        LadderPrinter.printLadder(ladder);
    }
}
