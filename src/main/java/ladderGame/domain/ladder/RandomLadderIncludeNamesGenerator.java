package ladderGame.domain.ladder;

import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.domain.ladderConfig.LadderIncludeNamesConfig;
import ladderGame.exception.ladderException.TypeMissMatchException;

import java.util.List;

public class RandomLadderIncludeNamesGenerator extends RandomLadderGenerator {

    @Override
    public Ladder generate(LadderConfig ladderConfig) {
        final LadderIncludeNamesConfig ladderIncludeNamesConfig = checkLadderConfigType(ladderConfig);

        final int height = ladderIncludeNamesConfig.getHeight();
        final int numOfPeople = ladderIncludeNamesConfig.getNumOfPeople();
        final List<String> nameList = ladderIncludeNamesConfig.getNameList();

        List<Branch> branches = makeBranches(height, numOfPeople);

        LadderIncludeNames ladder = new LadderIncludeNames(branches);
        ladder.addAllNames(nameList);

        return ladder;
    }

    private LadderIncludeNamesConfig checkLadderConfigType(LadderConfig ladderConfig) {
        if (!(ladderConfig instanceof LadderIncludeNamesConfig ladderIncludeNamesConfig)) {
            throw new TypeMissMatchException();
        }
        return ladderIncludeNamesConfig;
    }
}
