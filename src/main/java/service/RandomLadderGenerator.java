package service;

import dto.Ladder;
import dto.LadderInputInfo;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderGenerator implements LadderGenerator {

    @Override
    public Ladder buildLadder(LadderInputInfo ladderInputInfo) {
        List<StringBuilder> ladder = new ArrayList<>();
        int totalLines = ladderInputInfo.getHeights() + LadderSizeConfig.NUMBER_OF_NAME_LINE;
        initLadder(totalLines, ladder);
        return new Ladder(assembleLadder(ladderInputInfo, ladder), ladderInputInfo.getParticipantsNames());
    }

    private void initLadder(int totalLines, List<StringBuilder> ladder) {
        for (int i = 0; i < totalLines; i++) {
            ladder.add(new StringBuilder());
        }
    }

    private List<StringBuilder> assembleLadder(LadderInputInfo ladderInputInfo, List<StringBuilder> ladder) {
        int numberOfParticipants = ladderInputInfo.getNumberOfParticipants();
        for (int i = LadderSizeConfig.NUMBER_OF_NAME_LINE; i < ladder.size(); i++) {
            writeOneLadderLine(numberOfParticipants, ladder.get(i));
        }
        return ladder;
    }


    private void writeOneLadderLine(int numberOfParticipants, StringBuilder ladderLine) {
        ladderLine.append(LadderCharacter.FIRST_COLUMN);
        String pastConnection = LadderCharacter.NOT_CONNECTED;
        for (int j = 0; j < numberOfParticipants - 1; j++) {
            String currentConnection = connectOrNot(pastConnection);
            ladderLine.append(currentConnection).append(LadderCharacter.COLUMN);
            pastConnection = currentConnection;
        }
    }

    private String connectOrNot(String pastConnection) {
        if (pastConnection.equals(LadderCharacter.CONNECTED)) {
            return LadderCharacter.NOT_CONNECTED;
        }
        return RandomConnection.randomConnection();
    }
}
