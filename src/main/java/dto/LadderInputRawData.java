package dto;

import java.util.List;

public class LadderInputRawData {
    private final int numberOfParticipants;
    private final int heights;
    private final List<String> participantsNames;
    private final List<String> gameResultLine;

    public LadderInputRawData(int numberOfParticipants, int heights, List<String> participantsNames, List<String> gameResultLine) {
        this.numberOfParticipants = numberOfParticipants;
        this.heights = heights;
        this.participantsNames = participantsNames;
        this.gameResultLine = gameResultLine;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getHeights() {
        return heights;
    }

    public List<String> getParticipantsNames() {
        return participantsNames;
    }

    public List<String> getGameResultLine() {
        return gameResultLine;
    }
}
