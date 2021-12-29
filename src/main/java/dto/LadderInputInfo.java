package dto;

import java.util.List;

public class LadderInputInfo {
    private final int numberOfParticipants;
    private final int heights;
    private List<String> participantsNames;

    public LadderInputInfo(int numberOfParticipants, int heights, List<String> participantsNames) {
        this.numberOfParticipants = numberOfParticipants;
        this.heights = heights;
        this.participantsNames = participantsNames;
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

    public void setParticipantsNamesAfterPreprocessing(List<String> preprocessedParticipantsNames) {
        participantsNames = preprocessedParticipantsNames;
    }
}
