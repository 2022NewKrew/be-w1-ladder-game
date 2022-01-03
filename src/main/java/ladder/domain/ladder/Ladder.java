package ladder.domain.ladder;

import ladder.domain.bridge.Bridge;

import java.util.List;

public class Ladder {

    private final List<String> participants;
    private final List<String> results;
    private final int height;
    private final List<Bridge> bridges;

    public Ladder(LadderInfo ladderInfo, List<Bridge> bridges) {
        this.participants = ladderInfo.getParticipants();
        this.results = ladderInfo.getResults();
        this.height = ladderInfo.getHeight();
        this.bridges = bridges;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }

    public int getHeight() {
        return height;
    }

    public boolean isConnected(int bridgeWidth, int bridgeHeight) {
        return bridges.get(bridgeHeight).isConnected(bridgeWidth);
    }

    public int getNumOfParticipants() {
        return participants.size();
    }
}
