package ladder;

import ladder.domain.Ladder;
import static ladder.view.InputUtil.*;
import static ladder.view.OutputUtil.showResult;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        List<String> persons = inputPersons(false);
        List<String> results = inputResults(false, persons.size());
        int ladderHeight = inputLadderHeight(false);

        Ladder ladder = new Ladder(persons, ladderHeight, results);

        ladder.rideLadder();

        System.out.println(ladder);

        showResult(ladder.getMatched());
    }
}