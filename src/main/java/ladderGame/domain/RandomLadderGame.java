package ladderGame.domain;

import ladderGame.domain.ladder.RandomLadderGenerator;
import ladderGame.view.input.HeightAndNumOfPeopleInputInterface;
import ladderGame.view.output.LadderOutputInterface;

import java.util.List;

public class RandomLadderGame extends LadderGame {
    public RandomLadderGame() {
        super(
                new HeightAndNumOfPeopleInputInterface(),
                new RandomLadderGenerator(),
                List.of(new LadderOutputInterface())
        );
    }
}
