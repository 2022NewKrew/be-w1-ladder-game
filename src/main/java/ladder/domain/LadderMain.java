package ladder.domain;

import ladder.view.InputView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> people = inputView.inputPeople();

        Ladder.of(people, inputView.inputLadderHeight())
                .drawPeople(people)
                .drawLadder();
    }
}
