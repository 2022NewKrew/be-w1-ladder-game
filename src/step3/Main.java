package step3;

import step3.domain.Ladder;
import step3.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder();

        OutputView.getInstance().printLadder(ladder);
    }
}