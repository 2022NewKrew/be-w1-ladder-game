package service.domain;

import dto.LadderInputRawData;
import service.LadderSizeConfig;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderGenerator implements LadderGenerator {

    @Override
    public Ladder buildLadder(LadderInputRawData ladderInputRawData) {
        List<LadderLine> ladder = new ArrayList<>();
        initLadder(ladderInputRawData.getHeights(), ladder);
        return new Ladder(assembleLadder(ladderInputRawData, ladder), ladderInputRawData.getParticipantsNames(), ladderInputRawData.getGameResultLine());
    }

    private void initLadder(int totalLines, List<LadderLine> ladder) {
        for (int i = 0; i < totalLines; i++) {
            ladder.add(new LadderLine(new ArrayList<>()));
        }
    }

    private List<LadderLine> assembleLadder(LadderInputRawData ladderInputRawData, List<LadderLine> ladder) {
        int numberOfParticipants = ladderInputRawData.getNumberOfParticipants();
        for (LadderLine ladderLine : ladder) {
            writeOneLadderLine(numberOfParticipants, ladderLine);
        }
        return ladder;
    }


    private void writeOneLadderLine(int numberOfParticipants, LadderLine ladderLine) {
        Boolean pastConnection = false;
        for (int j = 0; j < numberOfParticipants - 1; j++) {
            Boolean currentConnection = connectOrNot(pastConnection);
            ladderLine.getIsLadderConnected().add(currentConnection);
            pastConnection = currentConnection;
        }
    }

    private Boolean connectOrNot(Boolean pastConnection) {
        if (pastConnection) {
            return false;
        }
        return RandomConnection.randomConnection();
    }
}
