import dto.LadderInputInfo;
import ladder.Ladder;
import ladder.LadderBuilder;
import ladder.LadderImplV2;
import ladder.RandomLadderBuilderV2;
import view.InputView;

public class Main {
//    private static LadderBuilder ladderBuilder = new RandomLadderBuilder();
    private static LadderBuilder ladderBuilder = new LadderImplV2.RandomLadderBuilder();
//    private static LadderBuilder ladderBuilder = new RandomLadderBuilderV2();

    public static void main(String[] args) {
        LadderInputInfo ladderInputInfo = InputView.getLadderInfo();

        Ladder ladder = ladderBuilder.createLadder(ladderInputInfo);

        ladder.print();
    }
}
