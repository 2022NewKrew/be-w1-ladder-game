package step3LadderGame.domain.ladderConfig;

import step2LadderGame.domain.ladderConfig.LadderConfig;

import java.util.ArrayList;
import java.util.List;

public class LadderIncludeParticipantsConfig extends LadderConfig {
    private final List<String> participants = new ArrayList<>();

    public List<String> getParticipants() {
        return participants;
    }

    public LadderIncludeParticipantsConfig(List<String> participants, int height) {
        super(participants.size(), height);
        addAllParticipants(participants);
    }

    private void addAllParticipants(List<String> nameList) {
        this.participants.addAll(nameList);
    }
}
