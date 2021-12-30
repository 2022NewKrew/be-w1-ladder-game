package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Layer> layers;
    private final List<String> participants;
    private final List<String> results;

    public Ladder(List<String> participants, List<String> results, List<Layer> layers) {
        this.participants = Collections.unmodifiableList(participants);
        this.results = Collections.unmodifiableList(results);
        this.layers = Collections.unmodifiableList(layers);
    }

    public List<Layer> getLayers () {
        return layers;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }
}
