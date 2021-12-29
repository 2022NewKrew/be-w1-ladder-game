package ladderGame.domain;

import ladderGame.domain.ladder.RandomLadderIncludeNamesGenerator;
import ladderGame.view.input.HeightAndPeopleNamesInputInterface;
import ladderGame.view.output.Ladder5sizeOutputInterface;
import ladderGame.view.output.NameOutputInterface;

import java.util.List;

public class RandomLadderIncludeNamesGame extends LadderGame {
    public RandomLadderIncludeNamesGame() {
        super(
                new HeightAndPeopleNamesInputInterface(),
                new RandomLadderIncludeNamesGenerator(),
                List.of(new NameOutputInterface(), new Ladder5sizeOutputInterface())
        );
    }
}
