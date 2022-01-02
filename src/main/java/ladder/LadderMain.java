package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;

import java.util.List;

public class LadderMain {
    public static final int MAX_LENGTH = 5;

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> people = inputView.inputPeople();

        Ladder.of(people, inputView.inputLadderHeight())
                .drawPeople(people)
                .drawLadder();
    }
}
