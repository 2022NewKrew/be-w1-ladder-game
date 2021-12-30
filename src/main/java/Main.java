import dto.LadderInputInfo;
import ladder.*;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Main {
//    private static LadderBuilder ladderBuilder = new RandomLadderBuilder();
    private static LadderBuilder ladderBuilder = LadderImpl.randomLadderBuilder;

    public static void main(String[] args) {
        LadderInputInfo ladderInputInfo = InputView.getLadderInfo();

        Ladder ladder = ladderBuilder.createLadder(ladderInputInfo);

        OutputView.showOutput(ladder);
    }
}
