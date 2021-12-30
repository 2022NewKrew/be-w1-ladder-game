package keith.domain;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Ladder {
    public static final int MAX_NAME_LEN = 5;

    private final List<String> participants;
    private final List<String> destinations;
    private final List<Line> connections;
    private final HashMap<String, Integer> startPoint;

    public Ladder(List<String> participants, List<String> destinations, int height) {
        if (participants.size() != destinations.size()) {
            throw new IllegalArgumentException("사람과 결과의 수가 다릅니다!");
        }

        this.participants = participants;
        this.destinations = destinations;
        this.connections = new ArrayList<>();
        this.startPoint = new HashMap<>();

        initializeConnections(this.connections, height);
        initializeStartPoint(this.startPoint, this.participants);
    }

    private void initializeConnections(List<Line> connections, int height) {
        for (int i = 0; i < height; i++) {
            connections.add(new Line(this.participants.size()));
        }
    }

    private void initializeStartPoint(HashMap<String, Integer> startPoint, List<String> participants) {
        for (int i = 0; i < participants.size(); i++) {
            startPoint.put(participants.get(i), i);
        }
    }

    public List<Line> getConnections() {
        return this.connections;
    }
    public List<String> getParticipants() {
        return this.participants;
    }
    public List<String> getDestinations() {
        return this.destinations;
    }
    public HashMap<String, Integer> getStartPoint() {
        return this.startPoint;
    }
}
