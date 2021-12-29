package dto;

import java.util.List;

public class Ladder {
    private final List<StringBuilder> ladder;
    private final List<String> participantsNames;

    public Ladder(List<StringBuilder> ladder, List<String> participantsNames) {
        this.ladder = ladder;
        this.participantsNames = participantsNames;
    }

    public List<String> getParticipantsNames() {
        return participantsNames;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (StringBuilder ladderLine : ladder) {
            res.append(ladderLine.toString()).append("\n");
        }
        return res.toString();
    }
}
