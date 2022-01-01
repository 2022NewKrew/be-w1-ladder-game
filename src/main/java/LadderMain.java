import domain.Ladder;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        List<String> namesOfPeople = InputView.getNamesOfPeople();
        int numOfPeople = namesOfPeople.size();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(numOfPeople, height);

        ResultView.printNamesAndLadder(namesOfPeople, ladder);
    }
}
