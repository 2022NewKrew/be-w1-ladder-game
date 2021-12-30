package keith.domain;

import java.util.List;
import java.util.ArrayList;

public class Ladder {
    public static final int MAX_NAME_LEN = 5;
    private final List<Line> connections;
    private final List<String> participants;

    public Ladder(List<String> participants, int height) {
        this.connections = new ArrayList<>();
        this.participants = participants;

        for (int i = 0; i < height; i++) {
            this.connections.add(new Line(this.participants.size()));
        }
    }

    public List<Line> getConnections() {
        return this.connections;
    }

    public List<String> getParticipants() {
        return this.participants;
    }
}
