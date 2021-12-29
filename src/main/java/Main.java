import ladder.LadderBuilder;
import dto.LadderInputInfo;
import view.InputView;
import ladder.domain.Ladder;
import ladder.RandomLadderBuilder;

public class Main {
    //static
    private static LadderBuilder ladderBuilder = new RandomLadderBuilder();

    public static void main(String[] args) {
        LadderInputInfo ladderInputInfo = InputView.inputLadderInfo();
        Ladder ladder = ladderBuilder.createLadder(ladderInputInfo);
        ladder.print();
    }
}
