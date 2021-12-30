import dto.LadderInputInfo;
import input.InputManager;
import ladder.*;
import view.InputView;
import view.OutputView;

public class Main {
    private static LadderBuilder ladderBuilder = LadderImpl.randomLadderBuilder;

    public static void main(String[] args) {
        LadderInputInfo ladderInputInfo = InputView.getLadderInfo();

        Ladder ladder = ladderBuilder.createLadder(ladderInputInfo);

        OutputView.show(ladder);

        InputManager.close();
    }
}
