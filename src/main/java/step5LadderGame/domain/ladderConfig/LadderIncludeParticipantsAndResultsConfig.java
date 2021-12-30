package step5LadderGame.domain.ladderConfig;

import step3LadderGame.domain.ladderConfig.LadderIncludeParticipantsConfig;

import java.util.ArrayList;
import java.util.List;

public class LadderIncludeParticipantsAndResultsConfig extends LadderIncludeParticipantsConfig {
    private final List<String> results = new ArrayList<>();

    public List<String> getResults() {
        return results;
    }

    public LadderIncludeParticipantsAndResultsConfig(List<String> participants, List<String> results, int height) {
        super(participants, height);
        addAllResults(results);
    }

    private void addAllResults(List<String> results) {
        this.results.addAll(results);
    }
}
