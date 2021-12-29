package ladder;

import ladder.domain.Ladder;
import static ladder.view.InputUtil.*;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        List<String> persons = inputPersons(false);
        int ladderHeight = inputLadderHeight(false);

        Ladder ladder = new Ladder(persons, ladderHeight);

        System.out.println(ladder);
    }
}