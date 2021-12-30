package service.domain;

import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;
    private final List<String> participantsNames;
    private final List<String> gameResultsLine;

    protected Ladder(List<LadderLine> ladder, List<String> participantsNames, List<String> gameResultsLine) {
        this.ladder = ladder;
        this.participantsNames = participantsNames;
        this.gameResultsLine = gameResultsLine;
    }

    public List<String> getParticipantsNames() {
        return participantsNames;
    }

    public List<String> getGameResultsLine() {
        return gameResultsLine;
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
