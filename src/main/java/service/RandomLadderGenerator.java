package service;

import dto.Ladder;
import dto.LadderCharacter;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RandomLadderGenerator implements LadderGenerator {

    @Override
    public Ladder buildLadder(int heights, int numberOfParticipants) {
        List<StringBuilder> ladder = new ArrayList<>();
        initLadder(heights, ladder);
        return new Ladder(assembleLadder(numberOfParticipants, ladder));
    }

    private void initLadder(int heights, List<StringBuilder> ladder) {
        for (int i = 0; i < heights; i++) {
            ladder.add(new StringBuilder());
        }
    }

    private List<StringBuilder> assembleLadder(int numberOfParticipants, List<StringBuilder> ladder) {
        return ladder.stream()
                .map(ladderLine -> writeOneLadderLine(numberOfParticipants, ladderLine))
                .collect(toList());
    }

    private StringBuilder writeOneLadderLine(int numberOfParticipants, StringBuilder ladderLine) {
        ladderLine.append(LadderCharacter.COLUMN);
        for (int j = 0; j < numberOfParticipants - 1; j++) {
            ladderLine.append(RandomConnection.randomConnection()).append(LadderCharacter.COLUMN);
        }
        return ladderLine;
    }
}
