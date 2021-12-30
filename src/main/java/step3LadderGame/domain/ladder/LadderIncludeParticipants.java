package step3LadderGame.domain.ladder;

import step2LadderGame.domain.ladder.Branch;
import step2LadderGame.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderIncludeParticipants extends Ladder {

    private final List<String> participants = new ArrayList<>();

    public List<String> getParticipants() {
        return participants;
    }

    private void addAllParticipants(List<String> nameList) {
        this.participants.addAll(nameList);
    }

    protected LadderIncludeParticipants(List<Branch> branches, List<String> participants) {
        super(branches);
        addAllParticipants(participants);
    }
}
