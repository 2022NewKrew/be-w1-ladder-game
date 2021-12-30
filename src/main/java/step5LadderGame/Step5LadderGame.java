package step5LadderGame;

import step2LadderGame.Step2LadderGame;
import step3LadderGame.view.output.Ladder5sizeOutputInterface;
import step3LadderGame.view.output.ParticipantsOutputInterface;
import step5LadderGame.domain.ladder.RandomLadderIncludeParticipantsAndResultsGenerator;
import step5LadderGame.view.input.HeightAndParticipantsAndResultInputInterface;
import step5LadderGame.view.output.MatchingResultOutputInterface;
import step5LadderGame.view.output.ResultsOutputInterface;

import java.util.List;

public class Step5LadderGame extends Step2LadderGame {
    public Step5LadderGame() {
        super(
                new HeightAndParticipantsAndResultInputInterface(),
                new RandomLadderIncludeParticipantsAndResultsGenerator(),
                List.of(new ParticipantsOutputInterface(),
                        new Ladder5sizeOutputInterface(),
                        new ResultsOutputInterface(),
                        new MatchingResultOutputInterface())
        );
    }
}