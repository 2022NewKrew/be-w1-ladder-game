package step5LadderGame.domain.ladder;

import step2LadderGame.domain.ladder.Branch;
import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.domain.ladder.RandomLadderGenerator;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.exception.NotEqualSizeException;
import step5LadderGame.domain.ladderConfig.LadderIncludeParticipantsAndResultsConfig;

import java.util.List;

public class RandomLadderIncludeParticipantsAndResultsGenerator extends RandomLadderGenerator {

    @Override
    public Ladder generate(LadderConfig ladderConfig) {
        final LadderIncludeParticipantsAndResultsConfig ladderIncludeParticipantsConfig = checkLadderConfigType(ladderConfig);

        final int height = ladderIncludeParticipantsConfig.getHeight();
        final int numOfPeople = ladderIncludeParticipantsConfig.getNumOfParticipants();
        final List<String> participants = ladderIncludeParticipantsConfig.getParticipants();
        final List<String> results = ladderIncludeParticipantsConfig.getResults();

        final List<Branch> branches = makeBranches(height, numOfPeople);

        return new LadderIncludeParticipantsAndResults(branches, participants, results);
    }

    private LadderIncludeParticipantsAndResultsConfig checkLadderConfigType(LadderConfig ladderConfig) {
        if (!(ladderConfig instanceof LadderIncludeParticipantsAndResultsConfig ladderIncludeParticipantsAndResultsConfig))
            throw new NotEqualSizeException();
        return ladderIncludeParticipantsAndResultsConfig;
    }
}
