package ladder.domain.ladder;

import ladder.domain.bridge.Bridge;

import java.util.List;

public class Ladder {

    private final String[] participants;
    private final int height;
    private final List<Bridge> bridges;

    public Ladder(String[] participants, int height, List<Bridge> bridges) {
        this.participants = participants;
        this.height = height;
        this.bridges = bridges;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getHeight() {
        return height;
    }

    public boolean isConnected(int bridgeWidth, int bridgeHeight) {
        return bridges.get(bridgeHeight).isConnected(bridgeWidth);
    }
}
