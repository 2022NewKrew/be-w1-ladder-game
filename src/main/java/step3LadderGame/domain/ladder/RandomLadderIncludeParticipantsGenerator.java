package step3LadderGame.domain.ladder;

import step2LadderGame.domain.ladder.Branch;
import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.domain.ladder.RandomLadderGenerator;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.exception.NotEqualSizeException;
import step3LadderGame.domain.ladderConfig.LadderIncludeParticipantsConfig;

import java.util.List;

public class RandomLadderIncludeParticipantsGenerator extends RandomLadderGenerator {

    @Override
    public Ladder generate(LadderConfig ladderConfig) {
        final LadderIncludeParticipantsConfig ladderIncludeParticipantsConfig = checkLadderConfigType(ladderConfig);

        final int height = ladderIncludeParticipantsConfig.getHeight();
        final int numOfPeople = ladderIncludeParticipantsConfig.getNumOfParticipants();
        final List<String> nameList = ladderIncludeParticipantsConfig.getParticipants();

        final List<Branch> branches = makeBranches(height, numOfPeople);

        return new LadderIncludeParticipants(branches, nameList);
    }

    private LadderIncludeParticipantsConfig checkLadderConfigType(LadderConfig ladderConfig) {
        if (!(ladderConfig instanceof LadderIncludeParticipantsConfig ladderIncludeParticipantsConfig)) {
            throw new NotEqualSizeException();
        }
        return ladderIncludeParticipantsConfig;
    }
}
