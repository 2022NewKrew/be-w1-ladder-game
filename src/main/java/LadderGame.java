import java.util.List;

public class LadderGame {

    private List<String> users;
    private Ladder ladder;

    LadderGame() {}

    public void start() {

        users = InputView.askNames();
        ladder = new Ladder(users.size(), InputView.askHeight());
        OutputView.printLadder(ladder.getLines(), users);

    }

}
