public class LadderGame {

    public static void main(String[] args) {

        Ladder ladder = new Ladder(InputView.askNumOfPeople(), InputView.askHeight());
        OutputView.printLadder(ladder.getLadder());

    }
}
