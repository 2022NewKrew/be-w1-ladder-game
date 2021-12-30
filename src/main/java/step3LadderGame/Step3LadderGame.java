package step3LadderGame;

import step2LadderGame.Step2LadderGame;
import step2LadderGame.domain.ladder.RandomLadderGenerator;
import step2LadderGame.view.output.LadderOutputInterface;
import step3LadderGame.view.input.HeightAndParticipantsInputInterface;
import step3LadderGame.view.output.Ladder5sizeOutputInterface;
import step3LadderGame.view.output.ParticipantsOutputInterface;

import java.util.List;

public class Step3LadderGame extends Step2LadderGame {
    public Step3LadderGame() {
        super(
                new HeightAndParticipantsInputInterface(),
                new RandomLadderGenerator(),
                List.of(new ParticipantsOutputInterface(),
                        new Ladder5sizeOutputInterface())
        );
    }
}
